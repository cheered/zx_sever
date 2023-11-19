package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ZSYAnswerdetailsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 答题详细记录表，与题目表相关联
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:08
 */
@Mapper
public interface ZSYAnswerdetailsDao extends BaseMapper<ZSYAnswerdetailsEntity> {
	
}
