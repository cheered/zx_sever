package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZShowdetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer responseId;
    /**
     *
     */
    private List<ZShowquesion> questions;


    private Date createDate;

    private String type;


}
