package io.renren.modules.zx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.zx.entity.ResponsesEntity;

import java.util.Map;

/**
 * 答题记录表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
public interface ResponsesService extends IService<ResponsesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

