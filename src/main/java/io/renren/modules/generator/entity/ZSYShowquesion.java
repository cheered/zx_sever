package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ZSYShowquesion implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer question_id;
    /**
     *
     */

    private String quetions;

    private List<ZSYOptionsEntity> options;



}
