package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ZQuestionsDao;
import io.renren.modules.generator.entity.ZQuestionsEntity;
import io.renren.modules.generator.service.ZQuestionsService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("ZquestionsService")
public class ZQuestionsServiceImpl extends ServiceImpl<ZQuestionsDao, ZQuestionsEntity> implements ZQuestionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZQuestionsEntity> page = this.page(
                new Query<ZQuestionsEntity>().getPage(params),
                new QueryWrapper<ZQuestionsEntity>()
        );

        return new PageUtils(page);
    }

}