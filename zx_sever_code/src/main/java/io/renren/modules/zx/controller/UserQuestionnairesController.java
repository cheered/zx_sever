package io.renren.modules.zx.controller;

import java.util.*;
import io.renren.common.utils.R;
import io.renren.modules.zx.entity.*;
import io.renren.modules.zx.service.UserQuetstionnairesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/zx/user")
public class UserQuestionnairesController {
    @Resource
    private UserQuetstionnairesService userQuetstionnairesService;

    @GetMapping("/getQuestionnaires")
    public R getQuestionnaires(@RequestParam QuestionnairesEntity questionnairesEntity){
        try{
            List<QuestionnairesEntity> questionnaires = userQuetstionnairesService.getQuestionnaires(questionnairesEntity);
            return R.ok().put("questionnaires", questionnaires);
        } catch (Exception e){
            e.printStackTrace();
            return R.error(999999, "服务器异常");
        }
    }

    @GetMapping("/getQuestions")
    public R getQuestions(@RequestParam QuestionnairesEntity questionnairesEntity){
        try{
            List<QuestionsEntity> questions = userQuetstionnairesService.getQuestions(questionnairesEntity);
            return R.ok().put("questions", questions);
        } catch (Exception e){
            e.printStackTrace();
            return R.error(999999, "服务器异常");
        }
    }

    @PostMapping("/submitQuestionnaires")
    public R getQuestionnaires(@RequestParam QuestionnairesQuestionsDTO questionnairesQuestionsDTO){
        try{
            userQuetstionnairesService.submitQuestionnaires(questionnairesQuestionsDTO);
            return R.ok("提交成功");
        } catch (Exception e){
            e.printStackTrace();
            return R.error(999999, "服务器异常");
        }
    }


    @GetMapping("getResponses")
    public R getResponses(){
        try{
            List<ResponsesEntity> responses = userQuetstionnairesService.getResponses();
            return R.ok().put("responses", responses);
        } catch (Exception e){
            e.printStackTrace();
            return R.error(999999, "服务器异常");
        }

    }
}
