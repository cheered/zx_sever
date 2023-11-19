package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZSYOptionsEntity;

import java.util.Map;

/**
 * 选项表，关联题目表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
public interface ZSYOptionsService extends IService<ZSYOptionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

