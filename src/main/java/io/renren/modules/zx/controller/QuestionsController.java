package io.renren.modules.zx.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.zx.entity.OptionsEntity;
import io.renren.modules.zx.service.OptionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.zx.entity.QuestionsEntity;
import io.renren.modules.zx.service.QuestionsService;
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
@RequestMapping("zx/questions")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private OptionsService optionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("zx:questions:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = questionsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息展示
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("zx:questions:info")
    public R info(@PathVariable("id") Long id){
        // 通过ID查询到question对象
		QuestionsEntity questions = questionsService.getById(id);
		// 构建一个QuestionEntity的查询对象
        QueryWrapper<OptionsEntity> queryWrapper = new QueryWrapper<>();
        // 查询拥有当前这个question_id的对象
        queryWrapper.eq("question_id", id);
        List<OptionsEntity> list = optionsService.list(queryWrapper);
        questions.setOptions(list);
        return R.ok().put("questions", questions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:questions:save")
    public R save(@RequestBody QuestionsEntity questions){
        // System.out.println(questions.toString());
        // 保存question对象
		questionsService.save(questions);
        for (OptionsEntity op:questions.getOptions()) {
            // 将当前题目ID保存到涉及的四个选项中
            op.setQuestionId(questions.getId());
            optionsService.save(op);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:questions:update")
    public R update(@RequestBody QuestionsEntity questions){
		questionsService.updateById(questions);
        for (OptionsEntity op: questions.getOptions()) {
            optionsService.updateById(op);
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:questions:delete")
    public R delete(@RequestBody Long[] ids){
		questionsService.removeByIds(Arrays.asList(ids));
        for (Long id: ids) {
            QueryWrapper<OptionsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("question_id", id);
            optionsService.remove(queryWrapper);
        }
        return R.ok();
    }

}
