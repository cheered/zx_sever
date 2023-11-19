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
@TableName("options")
public class ZOptionsEntity implements Serializable {
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
