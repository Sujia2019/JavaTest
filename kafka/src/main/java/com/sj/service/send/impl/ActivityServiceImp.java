package com.sj.service.send.impl;


import com.sj.dao.ActivityMapper;
import com.sj.model.Activity;
import com.sj.service.Message;
import com.sj.statics.StaticConfigs;
import com.sj.service.send.ActivityService;
import com.sj.statics.CODE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImp implements ActivityService {
    private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImp.class);
    @Autowired
    ActivityMapper mapper;
    @Autowired
    KafkaTemplate<Integer, Message> template;

    public Activity savePlan(Activity activity) throws Exception {
        //数据库保存方案
        mapper.savePlan(activity);
        //通过kafka推送
        /*
          推送
         */
        Message message = new Message();
        message.setMsgCode(CODE.PUSH_ACTIVITY.getValue());
        message.setObj(activity);
        //设置要发送到哪个具体的topic
        template.setDefaultTopic(StaticConfigs.TOPIC_PUSH_ACTIVITY);
        template.sendDefault(activity.getActivityId(), message);
        template.flush();
        return activity;
    }
}
