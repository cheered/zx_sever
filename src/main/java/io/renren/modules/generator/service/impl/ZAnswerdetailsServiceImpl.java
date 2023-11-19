package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ZAnswerdetailsDao;
import io.renren.modules.generator.entity.ZAnswerdetailsEntity;
import io.renren.modules.generator.entity.ZOptionsEntity;
import io.renren.modules.generator.entity.ZQuestionsEntity;
import io.renren.modules.generator.entity.ZShowdetailsEntity;
import io.renren.modules.generator.service.ZAnswerdetailsService;
import io.renren.modules.generator.service.ZOptionsService;
import io.renren.modules.generator.service.ZQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("ZanswerdetailsService")
public class ZAnswerdetailsServiceImpl extends ServiceImpl<ZAnswerdetailsDao, ZAnswerdetailsEntity> implements ZAnswerdetailsService {
    @Autowired
    private ZQuestionsService ZQuestionsService;

    @Autowired
    private ZOptionsService ZOptionsService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZAnswerdetailsEntity> page = this.page(
                new Query<ZAnswerdetailsEntity>().getPage(params),
                new QueryWrapper<ZAnswerdetailsEntity>()
        );

        return new PageUtils(page);
    }

//    @Override
//    public ZShowdetailsEntity showdetails(Integer response_id, Integer question_id, Integer option_id) {
//        ZShowdetailsEntity res = new ZShowdetailsEntity();
//        ZQuestionsEntity question = ZQuestionsService.getById(question_id);
//        ZOptionsEntity option = ZOptionsService.getById(option_id);
//        res.setQuestions(question.getContent());
//        res.setOption(option.getContent());
//        return res;
//    }

}