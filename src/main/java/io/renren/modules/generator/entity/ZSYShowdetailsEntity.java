package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZSYShowdetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer responseId;
    /**
     *
     */
    private List<ZSYShowquesion> questions;


    private Date createDate;

    private String type;


}
