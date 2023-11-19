package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.generator.dao.ZResponsesDao;
import io.renren.modules.generator.entity.ZResponsesEntity;
import io.renren.modules.generator.service.ZResponsesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("ZresponsesService")
public class ZResponsesServiceImpl extends ServiceImpl<ZResponsesDao, ZResponsesEntity> implements ZResponsesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZResponsesEntity> page = this.page(
                new Query<ZResponsesEntity>().getPage(params),
                new QueryWrapper<ZResponsesEntity>()
        );



        return new PageUtils(page);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params, List<?> list) {
        int curPage = 1;
        int limit = 10;

        if(params.get(Constant.PAGE) != null){
            curPage = Integer.parseInt((String)params.get(Constant.PAGE));
        }
        if(params.get(Constant.LIMIT) != null){
            limit = Integer.parseInt((String)params.get(Constant.LIMIT));
        }

        return new PageUtils(list,list.size(),limit,curPage);
    }

}