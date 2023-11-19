package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ZQuestionnairesDao;
import io.renren.modules.generator.entity.*;
import io.renren.modules.generator.service.ZOptionsService;
import io.renren.modules.generator.service.ZQuestionnairesService;
import io.renren.modules.generator.service.ZQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("ZquestionnairesService")
public class ZQuestionnairesServiceImpl extends ServiceImpl<ZQuestionnairesDao, ZQuestionnairesEntity> implements ZQuestionnairesService {

    @Autowired
    private ZQuestionsService ZQuestionsService;

    @Autowired
    private ZOptionsService ZOptionsService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZQuestionnairesEntity> page = this.page(
                new Query<ZQuestionnairesEntity>().getPage(params),
                new QueryWrapper<ZQuestionnairesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public ZShowquestionnaires showquestionnaires(String customer_type, String business_type) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_type", customer_type);
        map.put("business_type", business_type);
        List<ZQuestionnairesEntity> questionnairesEntities = this.listByMap(map);
        ZQuestionnairesEntity quesnair = questionnairesEntities.get(0);

        HashMap<String, Object> questionmap = new HashMap<>();
        questionmap.put("questionnaire_id", quesnair.getQuestionnaireId());
        List<ZQuestionsEntity> questions = ZQuestionsService.listByMap(questionmap);

        List<ZShowquesion> ZShowquesionList = new ArrayList<>();
        for(int i = 0; i < questions.size(); i++){
            HashMap<String, Object> optionsmap = new HashMap<>();
            optionsmap.put("question_id", questions.get(i).getQuestionId());
            List<ZOptionsEntity> options = ZOptionsService.listByMap(questionmap);
            ZShowquesion ZShowquesion = new ZShowquesion();
            ZShowquesion.setQuestion_id(questions.get(i).getQuestionId());
            ZShowquesion.setOptions(options);
            ZShowquesion.setQuetions(questions.get(i).getContent());
            ZShowquesionList.add(ZShowquesion);
        }
        ZShowquestionnaires ZShowquestionnaires = new ZShowquestionnaires();
        ZShowquestionnaires.setQuestionnaires_id(quesnair.getQuestionnaireId());
        ZShowquestionnaires.setQuestions(ZShowquesionList);
        ZShowquestionnaires.setBusiness_type(business_type);
        return ZShowquestionnaires;
    }

}