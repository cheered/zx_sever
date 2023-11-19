package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.generator.entity.*;
import io.renren.modules.generator.service.*;
import io.renren.modules.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 10:23:53
 */
@RestController
@RequestMapping("generator/responses")
@Api("问卷记录接口")
public class ResController extends AbstractController {
    @Autowired
    private ZResponsesService zresponsesService;

    @Autowired
    private ZAnswerdetailsService zanswerdetailsService;

    @Autowired
    private ZQuestionsService zquestionsService;

    @Autowired
    private ZOptionsService zoptionsService;

    @Autowired
    private ZQuestionnairesService zquestionnairesService;

//    /**
//     * 获取答案
//     */
//    @RequestMapping("/answer")
//    @RequiresPermissions("generator:responses:answer")
//    public R answer(@RequestBody Answerquestionnaires answerquestionnaires){
//        SysUserEntity user1 = getUser();
//
//        ResponsesEntity responsesEntity = new ResponsesEntity();
//        responsesEntity.setUserId(Math.toIntExact(user1.getUserId()));
//        responsesEntity.setQuestionnaireId(answerquestionnaires.getQuestionnaires_id());
//        responsesEntity.setCompletiontime(answerquestionnaires.getCompletionTime());
//        responsesEntity.setTotalscore("666");
//        responsesService.save(responsesEntity);
//
//        AnswerdetailsEntity answerdetailsEntity = new AnswerdetailsEntity();
//        List<Answerquestion> questions = answerquestionnaires.getQuestions();
//        for(int i = 0; i < questions.size(); i++){
//            answerdetailsEntity.setResponseId(responsesEntity.getResponseId());
//            answerdetailsEntity.setQuestionId(questions.get(i).getQuestion_id());
//            answerdetailsEntity.setOptionId(questions.get(i).getOptions_id());
//            answerdetailsService.save(answerdetailsEntity);
//        }
//        return R.ok();
//    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:responses:list")
    public R list(@RequestParam Map<String, Object> params, @LoginUser UserEntity user){
        PageUtils page = zresponsesService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{responseId}")
    @RequiresPermissions("generator:responses:info")
    public R info(@PathVariable("responseId") Integer responseId){
		ZResponsesEntity responses = zresponsesService.getById(responseId);

        return R.ok().put("responses", responses);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:responses:save")
    public R save(@RequestBody ZResponsesEntity responses){
		zresponsesService.save(responses);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:responses:update")
    public R update(@RequestBody ZResponsesEntity responses){
		zresponsesService.updateById(responses);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:responses:delete")
    public R delete(@RequestBody Integer[] responseIds){
		zresponsesService.removeByIds(Arrays.asList(responseIds));

        return R.ok();
    }

    @GetMapping("/info/{response_id}")
    @RequiresPermissions("generator:responses:info")
    @ApiOperation("id查询")
    public R detail(@PathVariable("response_id") Integer response_id){
        ZResponsesEntity responses = zresponsesService.getById(response_id);
        HashMap<String,Object> response_id1 = new HashMap<>();
        response_id1.put("response_id", response_id);
        List<ZAnswerdetailsEntity> zAnswerdetailsEntities = zanswerdetailsService.listByMap(response_id1);
        ZShowdetailsEntity res = new ZShowdetailsEntity();
        res.setResponseId(response_id);
        HashMap<Integer, ZShowquesion> questionMap = new HashMap<>();
        for (ZAnswerdetailsEntity zAnswerdetailsEntity : zAnswerdetailsEntities) {
            ZQuestionsEntity questionsEntity = zquestionsService.getById(zAnswerdetailsEntity.getQuestionId());
            ZOptionsEntity optionsEntity = zoptionsService.getById(zAnswerdetailsEntity.getOptionId());

            if(questionMap.containsKey(questionsEntity.getQuestionId())){
                ZShowquesion zShowquesion = questionMap.get(questionsEntity.getQuestionId());
                zShowquesion.getOptions().add(optionsEntity);

            }else{
                ZShowquesion zShowquesion = new ZShowquesion();
                zShowquesion.setQuestion_id(questionsEntity.getQuestionId());
                zShowquesion.setQuetions(questionsEntity.getContent());
                zShowquesion.setOptions(new ArrayList<ZOptionsEntity>(){{add(optionsEntity);}});
                questionMap.put(questionsEntity.getQuestionId(),zShowquesion);
            }
        }
        res.setQuestions(questionMap.values().stream().collect(Collectors.toList()));
        ZResponsesEntity zResponsesEntity = zresponsesService.getById(response_id);
        res.setCreateDate(zResponsesEntity.getCreatetime());
        res.setType(zquestionnairesService.getById(zResponsesEntity.getQuestionnaireId()).getBusinessType());
        return R.ok().put("detail", res);
    }


//    @RequestMapping("/business_type")
//    @RequiresPermissions("generator:responses:business_type")
//    public R selecttype(@RequestParam Map<String, Object> params, @PathVariable("business_type") String business_type){
//        SysUserEntity user1 = getUser();
//        HashMap<String, Object> user = new HashMap<>();
//        user.put("user_id", user1.getUserId());
//        List<ResponsesEntity> responses = responsesService.listByMap(user);
//        ArrayList<QuestionnairesEntity> questionnaires = new ArrayList<>();
//        for(int i = 0; i < responses.size(); i++){
//            QuestionnairesEntity questionnaire = questionnairesService.getById(responses.get(i).getQuestionnaireId());
//            if(questionnaire.getBusinessType().equals(business_type)){
//                questionnaires.add(questionnaire);
//            }
//        }
//        PageUtils page = responsesService.queryPage(params, questionnaires);
//        return R.ok().put("page", page);
//    }
}
