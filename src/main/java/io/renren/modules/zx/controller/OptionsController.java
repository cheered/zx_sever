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

import io.renren.modules.zx.entity.OptionsEntity;
import io.renren.modules.zx.service.OptionsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 选项表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@RestController
@RequestMapping("zx/options")
public class OptionsController {
    @Autowired
    private OptionsService optionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("zx:options:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = optionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("zx:options:info")
    public R info(@PathVariable("id") Long id){
		OptionsEntity options = optionsService.getById(id);

        return R.ok().put("options", options);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:options:save")
    public R save(@RequestBody OptionsEntity options){
		optionsService.save(options);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:options:update")
    public R update(@RequestBody OptionsEntity options){
		optionsService.updateById(options);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:options:delete")
    public R delete(@RequestBody Long[] ids){
		optionsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
