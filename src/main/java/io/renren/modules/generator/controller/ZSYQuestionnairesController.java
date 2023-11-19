package io.renren.modules.generator.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.generator.entity.ZSYResponseEntity;
import io.renren.modules.generator.service.ZSYResponseService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.ZSYQuestionnairesEntity;
import io.renren.modules.generator.service.ZSYQuestionnairesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 问卷表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-19 15:06:09
 */
@RestController
@RequestMapping("generator/questionnaires")
public class ZSYQuestionnairesController extends AbstractController {
    @Autowired
    private ZSYQuestionnairesService ZSYQuestionnairesService;

    @Autowired
    private ZSYResponseService zsyresponseService;

    /**
     * 显示问卷剩余作答次数
     */
    @GetMapping("/remainnumber/{businessType}")
    @ApiOperation("次数查询")
    public R remainnumber(@PathVariable("businessType") String business_type){
        if(business_type.equals("licai")){
            business_type = "理财";
        }else if(business_type.equals("jijin")){
            business_type = "基金";
        }else if(business_type.equals("ziguan")){
            business_type = "资管";
        }else if(business_type.equals("xintuo")){
            business_type = "信托";
        }
        SysUserEntity user1 = getUser();
        HashMap<String, Object> ans = new HashMap<>();
        ans.put("user_id", user1.getUserId());
        List<ZSYResponseEntity> responsesEntities = zsyresponseService.listByMap(ans);
        int day = 3;
        int year = 10;
        for(int i = 0; i < responsesEntities.size(); i++){
            HashMap<String, Object> questionnaire = new HashMap<>();
            questionnaire.put("questionnaire_id", responsesEntities.get(i).getQuestionnaireId());
            List<ZSYQuestionnairesEntity> questionnaires = ZSYQuestionnairesService.listByMap(questionnaire);
            if(questionnaires.get(0).getBusinessType().equals(business_type)){
                long l = System.currentTimeMillis();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formatnow = dateFormat.format(l);
                String formatdb = dateFormat.format(responsesEntities.get(i).getCreatetime());
                if(formatnow.equals(formatdb)){
                    day--;
                }
                String yearnow = String.format("%tY", l);
                String yeardb = String.format("%tY", responsesEntities.get(i).getCreatetime());
                if(yearnow.equals(yeardb)){
                    year--;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(day);
        res.add(year);
        return R.ok().put("remainnumber", res);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:questionnaires:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ZSYQuestionnairesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{questionnaireId}")
    @RequiresPermissions("generator:questionnaires:info")
    public R info(@PathVariable("questionnaireId") Integer questionnaireId){
		ZSYQuestionnairesEntity questionnaires = ZSYQuestionnairesService.getById(questionnaireId);

        return R.ok().put("questionnaires", questionnaires);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:questionnaires:save")
    public R save(@RequestBody ZSYQuestionnairesEntity questionnaires){
		ZSYQuestionnairesService.save(questionnaires);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:questionnaires:update")
    public R update(@RequestBody ZSYQuestionnairesEntity questionnaires){
		ZSYQuestionnairesService.updateById(questionnaires);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:questionnaires:delete")
    public R delete(@RequestBody Integer[] questionnaireIds){
		ZSYQuestionnairesService.removeByIds(Arrays.asList(questionnaireIds));

        return R.ok();
    }

}
