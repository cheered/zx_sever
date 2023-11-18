package io.renren.modules.zx.service;

import io.renren.modules.zx.entity.*;

import java.util.List;

public interface UserQuetstionnairesService {
    List<QuestionnairesEntity> getQuestionnaires(QuestionnairesEntity questionnairesEntity);
    List<QuestionsEntity> getQuestions(QuestionnairesEntity questionnairesEntity);
    void submitQuestionnaires(QuestionnairesQuestionsDTO questionnairesQuestionsDTO);
    List<ResponsesEntity> getResponses();

}
