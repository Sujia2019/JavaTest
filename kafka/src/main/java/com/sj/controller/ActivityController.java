package com.sj.controller;

import com.sj.model.Activity;
import com.sj.model.Response;
import com.sj.service.api.GetRemoteService;
import com.sj.service.send.ActivityServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    private static final Logger log = LoggerFactory.getLogger(ActivityController.class);
    @Autowired
    ActivityServiceImp activityService;

    @Autowired
    GetRemoteService getRemoteService;

    @RequestMapping("/savePlan")
    @ResponseBody
    public Response savePlan(@RequestParam Activity activity) {
        Response response = new Response();
        try {
            activity = activityService.savePlan(activity);
            response.setCode("success");
            response.setData("保存方案成功！方案id为:" + activity.getActivityId());
            log.info("保存策划成功: 方案id为【{}】", activity.getActivityId());
        } catch (Exception e) {
            response.setCode("error");
            response.setErrorMsg("保存策划方案时出错:" + e.getMessage());
            log.error("保存策划方案时出错: {}", e.getMessage());
        }
        return response;
    }

    @RequestMapping("/getPlan")
    @ResponseBody
    public Response getPlan(@RequestParam String type) {
        Response response = new Response();
        try {
            getRemoteService.get();
            response.setCode("success");
        } catch (Exception e) {
            response.setCode("error");
            response.setErrorMsg("获取策划方案出错:" + e.getMessage());
            log.error("获取策划方案出错:" + e.getMessage());
        }
        return response;
    }
}
