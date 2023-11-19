package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZSYResponseEntity;

import java.util.Map;

/**
 * 选项表，与问卷表关联
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
public interface ZSYResponseService extends IService<ZSYResponseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

