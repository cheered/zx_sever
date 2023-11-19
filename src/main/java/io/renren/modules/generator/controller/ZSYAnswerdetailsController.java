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

import io.renren.modules.generator.entity.ZSYAnswerdetailsEntity;
import io.renren.modules.generator.service.ZSYAnswerdetailsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 答题详细记录表，与题目表相关联
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:08
 */
@RestController
@RequestMapping("generator/answerdetails")
public class ZSYAnswerdetailsController {
    @Autowired
    private ZSYAnswerdetailsService ZSYAnswerdetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:answerdetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ZSYAnswerdetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{detailId}")
    @RequiresPermissions("generator:answerdetails:info")
    public R info(@PathVariable("detailId") Integer detailId){
		ZSYAnswerdetailsEntity answerdetails = ZSYAnswerdetailsService.getById(detailId);

        return R.ok().put("answerdetails", answerdetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:answerdetails:save")
    public R save(@RequestBody ZSYAnswerdetailsEntity answerdetails){
		ZSYAnswerdetailsService.save(answerdetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:answerdetails:update")
    public R update(@RequestBody ZSYAnswerdetailsEntity answerdetails){
		ZSYAnswerdetailsService.updateById(answerdetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:answerdetails:delete")
    public R delete(@RequestBody Integer[] detailIds){
		ZSYAnswerdetailsService.removeByIds(Arrays.asList(detailIds));

        return R.ok();
    }

}
