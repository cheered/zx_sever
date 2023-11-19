package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ZOptionsDao;
import io.renren.modules.generator.entity.ZOptionsEntity;
import io.renren.modules.generator.service.ZOptionsService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("ZoptionsService")
public class ZOptionsServiceImpl extends ServiceImpl<ZOptionsDao, ZOptionsEntity> implements ZOptionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZOptionsEntity> page = this.page(
                new Query<ZOptionsEntity>().getPage(params),
                new QueryWrapper<ZOptionsEntity>()
        );

        return new PageUtils(page);
    }

}