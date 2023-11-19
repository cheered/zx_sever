package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ZSYQuestionsDao;
import io.renren.modules.generator.entity.ZSYQuestionsEntity;
import io.renren.modules.generator.service.ZSYQuestionsService;


@Service("zsyquestionsService")
public class ZSYQuestionsServiceImpl extends ServiceImpl<ZSYQuestionsDao, ZSYQuestionsEntity> implements ZSYQuestionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZSYQuestionsEntity> page = this.page(
                new Query<ZSYQuestionsEntity>().getPage(params),
                new QueryWrapper<ZSYQuestionsEntity>()
        );

        return new PageUtils(page);
    }

}