package io.renren.modules.zx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.zx.entity.QuestionsEntity;

import java.util.Map;

/**
 * 题目表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
public interface QuestionsService extends IService<QuestionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

