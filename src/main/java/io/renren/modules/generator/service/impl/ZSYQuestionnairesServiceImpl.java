package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ZSYQuestionnairesDao;
import io.renren.modules.generator.entity.ZSYQuestionnairesEntity;
import io.renren.modules.generator.service.ZSYQuestionnairesService;


@Service("zsyquestionnairesService")
public class ZSYQuestionnairesServiceImpl extends ServiceImpl<ZSYQuestionnairesDao, ZSYQuestionnairesEntity> implements ZSYQuestionnairesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZSYQuestionnairesEntity> page = this.page(
                new Query<ZSYQuestionnairesEntity>().getPage(params),
                new QueryWrapper<ZSYQuestionnairesEntity>()
        );

        return new PageUtils(page);
    }

}