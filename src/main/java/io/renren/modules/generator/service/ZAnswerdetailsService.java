package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ZAnswerdetailsEntity;
import io.renren.modules.generator.entity.ZShowdetailsEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-11-18 10:23:53
 */
public interface ZAnswerdetailsService extends IService<ZAnswerdetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
//    ZShowdetailsEntity showdetails(Integer response_id, Integer question_id, Integer option_id);
}

