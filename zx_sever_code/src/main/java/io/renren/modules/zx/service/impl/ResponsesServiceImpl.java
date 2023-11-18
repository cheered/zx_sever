package io.renren.modules.zx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.zx.dao.ResponsesDao;
import io.renren.modules.zx.entity.ResponsesEntity;
import io.renren.modules.zx.service.ResponsesService;


@Service("responsesService")
public class ResponsesServiceImpl extends ServiceImpl<ResponsesDao, ResponsesEntity> implements ResponsesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ResponsesEntity> page = this.page(
                new Query<ResponsesEntity>().getPage(params),
                new QueryWrapper<ResponsesEntity>()
        );

        return new PageUtils(page);
    }

}