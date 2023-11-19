package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 问题表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@Data
@TableName("questions")
public class ZSYQuestionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer questionId;
	/**
	 * 
	 */
	private Integer questionnaireId;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date updatetime;
	/**
	 * 
	 */
	private Integer isdeleted;

}
