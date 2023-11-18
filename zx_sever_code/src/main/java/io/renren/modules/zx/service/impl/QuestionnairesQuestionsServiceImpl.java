package io.renren.modules.zx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.zx.dao.QuestionnairesQuestionsDao;
import io.renren.modules.zx.entity.QuestionnairesQuestionsEntity;
import io.renren.modules.zx.service.QuestionnairesQuestionsService;


@Service("questionnairesQuestionsService")
public class QuestionnairesQuestionsServiceImpl extends ServiceImpl<QuestionnairesQuestionsDao, QuestionnairesQuestionsEntity> implements QuestionnairesQuestionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuestionnairesQuestionsEntity> page = this.page(
                new Query<QuestionnairesQuestionsEntity>().getPage(params),
                new QueryWrapper<QuestionnairesQuestionsEntity>()
        );

        return new PageUtils(page);
    }

}