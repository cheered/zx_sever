package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.ZQuestionnairesEntity;
import io.renren.modules.generator.entity.ZResponsesEntity;
import io.renren.modules.generator.service.ZQuestionnairesService;
import io.renren.modules.generator.service.ZResponsesService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 15:27:03
 */
@RestController
@RequestMapping("generator/questionnaires")
@Api("问卷次数接口")
public class QuesnairesController extends AbstractController {
    @Autowired
    private ZQuestionnairesService ZQuestionnairesService;
    @Autowired
    private ZResponsesService responsesService;

//    /**
//     * 显示问卷
//     */
//    @RequestMapping("/show")
//    @RequiresPermissions("generator:questionnaires:show")
//    public R show(@PathVariable("customer_type") String customer_type, @PathVariable("business_type") String business_type){
//        Showquestionnaires showquestionnaires = questionnairesService.showquestionnaires(customer_type, business_type);
//        return R.ok().put("showquestionnaires", showquestionnaires);
//    }

    /**
     * 显示问卷剩余作答次数
     */
    @GetMapping("/remainnumber/{businessType}")
    @ApiOperation("次数查询")
    public R remainnumber(@PathVariable("businessType") String business_type){
        SysUserEntity user1 = getUser();
        HashMap<String, Object> ans = new HashMap<>();
        ans.put("user_id", user1.getUserId());
        List<ZResponsesEntity> responsesEntities = responsesService.listByMap(ans);
        int day = 3;
        int year = 10;
        for(int i = 0; i < responsesEntities.size(); i++){
            HashMap<String, Object> questionnaire = new HashMap<>();
            questionnaire.put("questionnaire_id", responsesEntities.get(i).getQuestionnaireId());
            List<ZQuestionnairesEntity> questionnaires = ZQuestionnairesService.listByMap(questionnaire);
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
        PageUtils page = ZQuestionnairesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{questionnaireId}")
    @RequiresPermissions("generator:questionnaires:info")
    public R info(@PathVariable("questionnaireId") Integer questionnaireId){
		ZQuestionnairesEntity questionnaires = ZQuestionnairesService.getById(questionnaireId);

        return R.ok().put("questionnaires", questionnaires);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:questionnaires:save")
    public R save(@RequestBody ZQuestionnairesEntity questionnaires){
		ZQuestionnairesService.save(questionnaires);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:questionnaires:update")
    public R update(@RequestBody ZQuestionnairesEntity questionnaires){
		ZQuestionnairesService.updateById(questionnaires);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:questionnaires:delete")
    public R delete(@RequestBody Integer[] questionnaireIds){
		ZQuestionnairesService.removeByIds(Arrays.asList(questionnaireIds));

        return R.ok();
    }

}
