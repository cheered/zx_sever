package io.renren.modules.zx.service.impl;

import io.renren.modules.zx.dao.UserQuestionnairesDao;
import io.renren.modules.zx.entity.*;
import io.renren.modules.zx.service.UserQuetstionnairesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnairesServiceImpl implements UserQuetstionnairesService {
    private UserQuestionnairesDao userQuestionnairesDao;

    @Override
    public List<QuestionnairesEntity> getQuestionnaires(QuestionnairesEntity questionnairesEntity){
        List<QuestionnairesEntity> questionnairesEntityList = userQuestionnairesDao.getQuestionnaires(questionnairesEntity);
        return questionnairesEntityList;
    }

    @Override
    public List<QuestionsEntity> getQuestions(QuestionnairesEntity questionnairesEntity){
        List<QuestionsEntity> questionsEntityList = userQuestionnairesDao.getQuestions(questionnairesEntity);
        for(QuestionsEntity questionsEntity : questionsEntityList){
            List<OptionsEntity> optionsEntityList = userQuestionnairesDao.getQuestionsOptions(questionsEntity);
            questionsEntity.setOptions(optionsEntityList);
        }
        return questionsEntityList;
    }

    @Override
    public void submitQuestionnaires(QuestionnairesQuestionsDTO questionnairesQuestionsDTO){
        int totalScore = 0;
        ResponsesEntity responsesEntity = new ResponsesEntity();
        responsesEntity.setUserId(questionnairesQuestionsDTO.getUserId());
        responsesEntity.setQuestionnaireId(questionnairesQuestionsDTO.getQuestionnaireId());
        List<QuestionnairesQuestionsEntity> questionnairesQuestionsEntityList = questionnairesQuestionsDTO.getQuestionnairesQuestionsEntityList();
        for(QuestionnairesQuestionsEntity questionnairesQuestionsEntity : questionnairesQuestionsEntityList){
            totalScore += userQuestionnairesDao.getQuestionScore(questionnairesQuestionsEntity);
        }
        responsesEntity.setTotalScore(totalScore);
        if(totalScore<=25){
            responsesEntity.setRiskLevel(RiskEnum.LOW);
        } else if (totalScore <=40) {
            responsesEntity.setRiskLevel(RiskEnum.MIDANDLOW);
        } else if (totalScore <=60) {
            responsesEntity.setRiskLevel(RiskEnum.MID);
        } else if (totalScore <=80) {
            responsesEntity.setRiskLevel(RiskEnum.MIDANDHIGH);
        } else {
            responsesEntity.setRiskLevel(RiskEnum.MIDANDHIGH);
        }
        userQuestionnairesDao.submitQuestionnaires(responsesEntity);

    }

    @Override
    public List<ResponsesEntity> getResponses(){
        List<ResponsesEntity> responsesEntityList = userQuestionnairesDao.getResponses();
        return responsesEntityList;
    }
}
