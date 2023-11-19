package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ZSYResponseDao;
import io.renren.modules.generator.entity.ZSYResponseEntity;
import io.renren.modules.generator.service.ZSYResponseService;


@Service("zsyresponseService")
public class ZSYResponseServiceImpl extends ServiceImpl<ZSYResponseDao, ZSYResponseEntity> implements ZSYResponseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZSYResponseEntity> page = this.page(
                new Query<ZSYResponseEntity>().getPage(params),
                new QueryWrapper<ZSYResponseEntity>()
        );

        return new PageUtils(page);
    }

}