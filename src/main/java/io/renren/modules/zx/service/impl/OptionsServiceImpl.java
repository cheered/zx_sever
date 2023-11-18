package io.renren.modules.zx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.zx.dao.OptionsDao;
import io.renren.modules.zx.entity.OptionsEntity;
import io.renren.modules.zx.service.OptionsService;


@Service("optionsService")
public class OptionsServiceImpl extends ServiceImpl<OptionsDao, OptionsEntity> implements OptionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OptionsEntity> page = this.page(
                new Query<OptionsEntity>().getPage(params),
                new QueryWrapper<OptionsEntity>()
        );

        return new PageUtils(page);
    }

}