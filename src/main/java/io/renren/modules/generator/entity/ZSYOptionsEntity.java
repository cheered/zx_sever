package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 选项表，关联题目表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@Data
@TableName("options")
public class ZSYOptionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer optionId;
	/**
	 * 
	 */
	private Integer questionId;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer score;
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
