package io.renren.modules.zx.entity;

import lombok.Data;

import java.util.List;

@Data
public class QuestionnairesQuestionsDTO {
    private Long userId;
    private Long questionnaireId;
    private List<QuestionnairesQuestionsEntity> questionnairesQuestionsEntityList;
}
