package io.renren.modules.zx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.zx.entity.OptionsEntity;

import java.util.Map;

/**
 * 选项表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
public interface OptionsService extends IService<OptionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

