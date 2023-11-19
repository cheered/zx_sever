package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZAnswerquestion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer question_id;

    private Integer options_id;

}
