package io.renren.modules.zx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 题目表
 * 
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@Data
@TableName("zx_questionnaires_questions")
public class QuestionnairesQuestionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long detailId;
	/**
	 * 答卷记录ID
	 */
	private Long responseId;
	/**
	 * 题目ID
	 */
	private Long questionId;
	/**
	 * 选项ID
	 */
	private Long optionId;
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
