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

import io.renren.modules.zx.entity.ResponsesEntity;
import io.renren.modules.zx.service.ResponsesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 答题记录表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@RestController
@RequestMapping("zx/responses")
public class ResponsesController {
    @Autowired
    private ResponsesService responsesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("zx:responses:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = responsesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("zx:responses:info")
    public R info(@PathVariable("id") Long id){
		ResponsesEntity responses = responsesService.getById(id);

        return R.ok().put("responses", responses);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:responses:save")
    public R save(@RequestBody ResponsesEntity responses){
		responsesService.save(responses);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:responses:update")
    public R update(@RequestBody ResponsesEntity responses){
		responsesService.updateById(responses);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:responses:delete")
    public R delete(@RequestBody Long[] ids){
		responsesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
