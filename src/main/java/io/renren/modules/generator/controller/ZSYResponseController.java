package io.renren.modules.generator.controller;

import java.util.*;
import java.util.stream.Collectors;

import io.renren.modules.generator.entity.*;
import io.renren.modules.generator.service.*;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 选项表，与问卷表关联
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@RestController
@RequestMapping("generator/response")
public class ZSYResponseController {
    @Autowired
    private ZSYResponseService ZSYResponseService;

    @Autowired
    private ZSYAnswerdetailsService zsyanswerdetailsService;

    @Autowired
    private ZSYQuestionsService zsyquestionsService;

    @Autowired
    private ZSYOptionsService zsyoptionsService;

    @Autowired
    private ZSYQuestionnairesService zsyquestionnairesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:response:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ZSYResponseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{responseId}")
    @RequiresPermissions("generator:response:info")
    public R info(@PathVariable("responseId") Integer responseId){
		ZSYResponseEntity response = ZSYResponseService.getById(responseId);

        return R.ok().put("response", response);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:response:save")
    public R save(@RequestBody ZSYResponseEntity response){
		ZSYResponseService.save(response);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:response:update")
    public R update(@RequestBody ZSYResponseEntity response){
		ZSYResponseService.updateById(response);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:response:delete")
    public R delete(@RequestBody Integer[] responseIds){
		ZSYResponseService.removeByIds(Arrays.asList(responseIds));

        return R.ok();
    }


    @GetMapping("/info/{response_id}")
    @RequiresPermissions("generator:responses:info")
    @ApiOperation("id查询")
    public R detail(@PathVariable("response_id") Integer response_id){
        ZSYResponseEntity responses = ZSYResponseService.getById(response_id);
        HashMap<String,Object> response_id1 = new HashMap<>();
        response_id1.put("response_id", response_id);
        List<ZSYAnswerdetailsEntity> zAnswerdetailsEntities = zsyanswerdetailsService.listByMap(response_id1);
        ZSYShowdetailsEntity res = new ZSYShowdetailsEntity();
        res.setResponseId(response_id);
        HashMap<Integer, ZSYShowquesion> questionMap = new HashMap<>();
        for (ZSYAnswerdetailsEntity zAnswerdetailsEntity : zAnswerdetailsEntities) {
            ZSYQuestionsEntity questionsEntity = zsyquestionsService.getById(zAnswerdetailsEntity.getQuestionId());
            ZSYOptionsEntity optionsEntity = zsyoptionsService.getById(zAnswerdetailsEntity.getOptionId());

            if(questionMap.containsKey(questionsEntity.getQuestionId())){
                ZSYShowquesion zShowquesion = questionMap.get(questionsEntity.getQuestionId());
                zShowquesion.getOptions().add(optionsEntity);

            }else{
                ZSYShowquesion zShowquesion = new ZSYShowquesion();
                zShowquesion.setQuestion_id(questionsEntity.getQuestionId());
                zShowquesion.setQuetions(questionsEntity.getContent());
                zShowquesion.setOptions(new ArrayList<ZSYOptionsEntity>(){{add(optionsEntity);}});
                questionMap.put(questionsEntity.getQuestionId(),zShowquesion);
            }
        }
        res.setQuestions(questionMap.values().stream().collect(Collectors.toList()));
        ZSYResponseEntity zResponsesEntity = ZSYResponseService.getById(response_id);
        res.setCreateDate(zResponsesEntity.getCreatetime());
        res.setType(zsyquestionnairesService.getById(zResponsesEntity.getQuestionnaireId()).getBusinessType());
        return R.ok().put("detail", res);
    }

}
