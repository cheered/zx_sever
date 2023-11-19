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

import io.renren.modules.generator.entity.ZSYOptionsEntity;
import io.renren.modules.generator.service.ZSYOptionsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 选项表，关联题目表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@RestController
@RequestMapping("generator/options")
public class ZSYOptionsController {
    @Autowired
    private ZSYOptionsService ZSYOptionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:options:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ZSYOptionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{optionId}")
    @RequiresPermissions("generator:options:info")
    public R info(@PathVariable("optionId") Integer optionId){
		ZSYOptionsEntity options = ZSYOptionsService.getById(optionId);

        return R.ok().put("options", options);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:options:save")
    public R save(@RequestBody ZSYOptionsEntity options){
		ZSYOptionsService.save(options);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:options:update")
    public R update(@RequestBody ZSYOptionsEntity options){
		ZSYOptionsService.updateById(options);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:options:delete")
    public R delete(@RequestBody Integer[] optionIds){
		ZSYOptionsService.removeByIds(Arrays.asList(optionIds));

        return R.ok();
    }

}
