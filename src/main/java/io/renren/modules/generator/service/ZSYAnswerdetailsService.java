package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZSYAnswerdetailsEntity;

import java.util.Map;

/**
 * 答题详细记录表，与题目表相关联
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:08
 */
public interface ZSYAnswerdetailsService extends IService<ZSYAnswerdetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

