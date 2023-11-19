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
@TableName("questionnaires")
public class ZQuestionnairesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer questionnaireId;
	/**
	 * 问卷名称
	 */
	private String name;
	/**
	 * 客户类型
	 */
	private String customerType;
	/**
	 * 业务类型
	 */
	private String businessType;
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
