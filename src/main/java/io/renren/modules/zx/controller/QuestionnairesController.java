package io.renren.modules.zx.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.zx.entity.QuestionnairesQuestionsEntity;
import io.renren.modules.zx.entity.QuestionsEntity;
import io.renren.modules.zx.service.QuestionnairesQuestionsService;
import io.renren.modules.zx.service.QuestionsService;
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

    // 关联表
    @Autowired
    private QuestionnairesQuestionsService questionnairesQuestionsService;

    @Autowired
    private QuestionsService questionsService;

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
        List<QuestionsEntity> questionList = new ArrayList<>();
		// 拿到问卷
        QuestionnairesEntity questionnaires = questionnairesService.getById(id);
        // TODO 查询题目 为了节省时间,暂时使用代码构造查询语句逐个查询题目
        // 后面改为双表联合查询
        QueryWrapper<QuestionnairesQuestionsEntity> q1 = new QueryWrapper<>();
        q1.eq("questionnaire_id", id);
        // 查询关联表
        List<QuestionnairesQuestionsEntity> qqeList = questionnairesQuestionsService
                .list(q1);
        // 遍历关联表
        for (QuestionnairesQuestionsEntity qqe : qqeList) {
            // 查询问题,添加到list中
            questionList.add(questionsService.getById(qqe.getQuestionId()));
        }
        questionnaires.setQuestionList(questionList);
        return R.ok().put("questionnaires", questionnaires);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("zx:questionnaires:save")
    public R save(@RequestBody QuestionnairesEntity questionnaires){
        System.out.println(questionnaires.toString());
        // 保存问卷
		questionnairesService.save(questionnaires);
        // 向关联表中保存题目
		for(QuestionsEntity question : questionnaires.getQuestionList()){
		    QuestionnairesQuestionsEntity qqe = new QuestionnairesQuestionsEntity();
		    qqe.setQuestionId(question.getId());
		    qqe.setQuestionnaireId(questionnaires.getId());
            questionnairesQuestionsService.save(qqe);
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("zx:questionnaires:update")
    public R update(@RequestBody QuestionnairesEntity questionnaires){
		questionnairesService.updateById(questionnaires);
		// TODO 为了简单,先删除关联表的数据,然后再添加
        // 1 删除问卷中所有的题目
        QueryWrapper<QuestionnairesQuestionsEntity> queryWrapper = new QueryWrapper();
        queryWrapper.eq("questionnaire_id", questionnaires.getId());
        questionnairesQuestionsService.remove(queryWrapper);
        // 2 给问卷添加题目
        for(QuestionsEntity question : questionnaires.getQuestionList()){
            QuestionnairesQuestionsEntity qqe = new QuestionnairesQuestionsEntity();
            qqe.setQuestionId(question.getId());
            qqe.setQuestionnaireId(questionnaires.getId());
            questionnairesQuestionsService.save(qqe);
        }

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("zx:questionnaires:delete")
    public R delete(@RequestBody Long[] ids){
		questionnairesService.removeByIds(Arrays.asList(ids));
       //  删除关联表中所有的题目
        for (Long id : ids) {
            QueryWrapper<QuestionnairesQuestionsEntity> queryWrapper = new QueryWrapper();
            queryWrapper.eq("questionnaire_id", id);
            questionnairesQuestionsService.remove(queryWrapper);
        }
        return R.ok();
    }
}
