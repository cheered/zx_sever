package io.renren.modules.zx.dao;

import io.renren.modules.zx.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserQuestionnairesDao {
    List<QuestionnairesEntity> getQuestionnaires(@Param("dto") QuestionnairesEntity questionnairesEntity);
    List<QuestionsEntity> getQuestions(@Param("dto") QuestionnairesEntity questionnairesEntity);
    void submitQuestionnaires(@Param("dto") ResponsesEntity responsesEntity);
    List<ResponsesEntity> getResponses();
    List<OptionsEntity> getQuestionsOptions(@Param("dto") QuestionsEntity questionsEntity);
    Integer getQuestionScore(@Param("dto") QuestionnairesQuestionsEntity questionnairesQuestionsEntity);
}
