package io.renren.modules.zx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.zx.dao.QuestionsDao;
import io.renren.modules.zx.entity.QuestionsEntity;
import io.renren.modules.zx.service.QuestionsService;


@Service("questionsService")
public class QuestionsServiceImpl extends ServiceImpl<QuestionsDao, QuestionsEntity> implements QuestionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuestionsEntity> page = this.page(
                new Query<QuestionsEntity>().getPage(params),
                new QueryWrapper<QuestionsEntity>()
        );

        return new PageUtils(page);
    }

}