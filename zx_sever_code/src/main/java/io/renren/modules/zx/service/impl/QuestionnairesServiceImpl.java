package io.renren.modules.zx.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.zx.dao.QuestionnairesDao;
import io.renren.modules.zx.entity.QuestionnairesEntity;
import io.renren.modules.zx.service.QuestionnairesService;


@Service("questionnairesService")
public class QuestionnairesServiceImpl extends ServiceImpl<QuestionnairesDao, QuestionnairesEntity> implements QuestionnairesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuestionnairesEntity> page = this.page(
                new Query<QuestionnairesEntity>().getPage(params),
                new QueryWrapper<QuestionnairesEntity>()
        );

        return new PageUtils(page);
    }

}