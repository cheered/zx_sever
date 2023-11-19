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
 * @date 2023-11-18 15:27:03
 */
@Data
@TableName("questions")
public class ZQuestionsEntity implements Serializable {
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
	 * 题目内容
	 */
	private String content;
	/**
	 * 题目类型
	 */
	private String questionType;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 
	 */
	private Integer isdeleted;

}
