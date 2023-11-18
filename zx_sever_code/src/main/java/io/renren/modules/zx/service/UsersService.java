package io.renren.modules.zx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.zx.entity.UsersEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
public interface UsersService extends IService<UsersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

