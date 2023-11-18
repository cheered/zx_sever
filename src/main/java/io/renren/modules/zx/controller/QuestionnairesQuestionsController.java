package io.renren.modules.zx.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.zx.entity.QuestionnairesQuestionsEntity;
import io.renren.modules.zx.service.QuestionnairesQuestionsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 题目表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@RestController
@RequestMapping("zx/questionnairesquestions")
public class QuestionnairesQuestionsController {
    @Autowired
    private QuestionnairesQuestionsService questionnairesQuestionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("zx:questionnairesquestions:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = questionnairesQuestionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("zx:questionnairesquestions:info")
    public R info(@PathVariable("id") Long id){
		QuestionnairesQuestionsEntity questionnairesQuestions = questionnairesQuestionsService.getById(id);

        return R.ok().put("questionnairesQuestions", questionnairesQuestions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:questionnairesquestions:save")
    public R save(@RequestBody QuestionnairesQuestionsEntity questionnairesQuestions){
		questionnairesQuestionsService.save(questionnairesQuestions);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:questionnairesquestions:update")
    public R update(@RequestBody QuestionnairesQuestionsEntity questionnairesQuestions){
		questionnairesQuestionsService.updateById(questionnairesQuestions);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:questionnairesquestions:delete")
    public R delete(@RequestBody Long[] ids){
		questionnairesQuestionsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
