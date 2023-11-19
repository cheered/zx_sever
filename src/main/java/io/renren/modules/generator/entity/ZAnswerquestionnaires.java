package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ZAnswerquestionnaires implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer questionnaires_id;

    private String completionTime;

    private List<ZAnswerquestion> questions;


}

