package com.sj.service.api;

import com.sj.model.Activity;
import org.springframework.stereotype.Service;

/**
 * 对于 活动 相关的业务
 * 描述，推送，修改，保存，发布等等
 */
@Service
public interface ActivityService {

    /**
     * 保存一个策划方案
     *
     * @param activity
     * @return
     */
    public Activity savePlan(Activity activity) throws Exception;

    /**
     * 修改方案
     *
     * @param activity
     * @return
     * @throws Exception
     */
    public Activity modifyActivity(Activity activity) throws Exception;


}
