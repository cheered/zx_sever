package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ZSYOptionsDao;
import io.renren.modules.generator.entity.ZSYOptionsEntity;
import io.renren.modules.generator.service.ZSYOptionsService;


@Service("zsyoptionsService")
public class ZSYOptionsServiceImpl extends ServiceImpl<ZSYOptionsDao, ZSYOptionsEntity> implements ZSYOptionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZSYOptionsEntity> page = this.page(
                new Query<ZSYOptionsEntity>().getPage(params),
                new QueryWrapper<ZSYOptionsEntity>()
        );

        return new PageUtils(page);
    }

}