package io.renren.modules.zx.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 问卷表
 * 
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@Data
@TableName("zx_questionnaires")
public class QuestionnairesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 问卷名称
	 */
	private String questionnairesName;
	/**
	 * 问卷面向的客户类型
	 */
	private Integer customerType;
	/**
	 * 问卷面向的业务类型
	 */
	private Integer businessType;

	/**
	 * 题目内容
	 */
	@TableField(exist = false)
	private List<QuestionsEntity> questions;

	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 逻辑删除标志
	 */
	private Integer isDeleted;



}
