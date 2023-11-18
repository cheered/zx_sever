package io.renren.modules.zx.dao;

import io.renren.modules.zx.entity.QuestionsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目表
 * 
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@Mapper
public interface QuestionsDao extends BaseMapper<QuestionsEntity> {
	
}
