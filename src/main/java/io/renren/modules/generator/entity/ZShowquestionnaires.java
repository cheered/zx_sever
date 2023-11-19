package io.renren.modules.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ZShowquestionnaires implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer questionnaires_id;

    private String business_type;

    private List<ZShowquesion> questions;



}

