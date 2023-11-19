package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 选项表，与问卷表关联
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@Data
@TableName("response")
public class ZSYResponseEntity implements Serializable {
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
	 * 
	 */
	private Integer questionnaireId;
	/**
	 * 
	 */
	private Date completiontime;
	/**
	 * 
	 */
	private Integer totalscore;
	/**
	 * 
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date updatetimt;
	/**
	 * 
	 */
	private Integer isdeleted;

}
