package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ZSYOptionsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 选项表，关联题目表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@Mapper
public interface ZSYOptionsDao extends BaseMapper<ZSYOptionsEntity> {
	
}
