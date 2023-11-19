package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 答题详细记录表，与题目表相关联
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:08
 */
@Data
@TableName("answerdetails")
public class ZSYAnswerdetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer detailId;
	/**
	 * 
	 */
	private Integer responseId;
	/**
	 * 
	 */
	private Integer questionId;
	/**
	 * 
	 */
	private Integer optionId;
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
