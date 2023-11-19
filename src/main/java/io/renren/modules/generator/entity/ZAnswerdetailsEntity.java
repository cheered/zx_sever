package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 10:23:53
 */
@Data
@TableName("answerdetails")
public class ZAnswerdetailsEntity implements Serializable {
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
	 * 完成时间
	 */
	private String createtime;
	/**
	 * 
	 */
	private Integer isdeleted;

}
