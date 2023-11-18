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

import io.renren.modules.zx.entity.QuestionnairesEntity;
import io.renren.modules.zx.service.QuestionnairesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 问卷表
 *
 * @author du
 * @email 18234153385@163.com
 * @date 2023-11-17 21:46:09
 */
@RestController
@RequestMapping("zx/questionnaires")
public class QuestionnairesController {
    @Autowired
    private QuestionnairesService questionnairesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("zx:questionnaires:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = questionnairesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("zx:questionnaires:info")
    public R info(@PathVariable("id") Long id){
		QuestionnairesEntity questionnaires = questionnairesService.getById(id);

        return R.ok().put("questionnaires", questionnaires);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:questionnaires:save")
    public R save(@RequestBody QuestionnairesEntity questionnaires){
		questionnairesService.save(questionnaires);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:questionnaires:update")
    public R update(@RequestBody QuestionnairesEntity questionnaires){
		questionnairesService.updateById(questionnaires);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:questionnaires:delete")
    public R delete(@RequestBody Long[] ids){
		questionnairesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
