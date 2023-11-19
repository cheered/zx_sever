package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ZSYAnswerdetailsDao;
import io.renren.modules.generator.entity.ZSYAnswerdetailsEntity;
import io.renren.modules.generator.service.ZSYAnswerdetailsService;


@Service("zsyanswerdetailsService")
public class ZSYAnswerdetailsServiceImpl extends ServiceImpl<ZSYAnswerdetailsDao, ZSYAnswerdetailsEntity> implements ZSYAnswerdetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZSYAnswerdetailsEntity> page = this.page(
                new Query<ZSYAnswerdetailsEntity>().getPage(params),
                new QueryWrapper<ZSYAnswerdetailsEntity>()
        );

        return new PageUtils(page);
    }

}