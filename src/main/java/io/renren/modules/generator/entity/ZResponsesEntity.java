package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 10:23:53
 */
@Data
@TableName("responses")
public class ZResponsesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer responseId;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 问卷
	 */
	private Integer questionnaireId;
	/**
	 * 完成用时
	 */
	private String completiontime;
	/**
	 * 风险评级
	 */
	private String totalscore;
	/**
	 * 完成时间
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Integer isdeleted;

 }
