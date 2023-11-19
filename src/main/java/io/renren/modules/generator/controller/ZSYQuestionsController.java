package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ZSYQuestionsEntity;
import io.renren.modules.generator.service.ZSYQuestionsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 问题表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@RestController
@RequestMapping("generator/questions")
public class ZSYQuestionsController {
    @Autowired
    private ZSYQuestionsService ZSYQuestionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:questions:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ZSYQuestionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{questionId}")
    @RequiresPermissions("generator:questions:info")
    public R info(@PathVariable("questionId") Integer questionId){
		ZSYQuestionsEntity questions = ZSYQuestionsService.getById(questionId);

        return R.ok().put("questions", questions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:questions:save")
    public R save(@RequestBody ZSYQuestionsEntity questions){
		ZSYQuestionsService.save(questions);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:questions:update")
    public R update(@RequestBody ZSYQuestionsEntity questions){
		ZSYQuestionsService.updateById(questions);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:questions:delete")
    public R delete(@RequestBody Integer[] questionIds){
		ZSYQuestionsService.removeByIds(Arrays.asList(questionIds));

        return R.ok();
    }

}
