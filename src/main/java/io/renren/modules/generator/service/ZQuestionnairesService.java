package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZQuestionnairesEntity;
import io.renren.modules.generator.entity.ZShowquestionnaires;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 15:27:03
 */
public interface ZQuestionnairesService extends IService<ZQuestionnairesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    ZShowquestionnaires showquestionnaires(String customer_type, String business_type);
}

