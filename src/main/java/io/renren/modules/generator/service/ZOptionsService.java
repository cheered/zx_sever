package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZOptionsEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 15:27:03
 */
public interface ZOptionsService extends IService<ZOptionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

