package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZSYQuestionnairesEntity;

import java.util.Map;

/**
 * 问卷表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
public interface ZSYQuestionnairesService extends IService<ZSYQuestionnairesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

