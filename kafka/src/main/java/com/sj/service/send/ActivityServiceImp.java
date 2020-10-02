package com.sj.service.send;


import com.sj.dao.ActivityMapper;
import com.sj.model.Activity;
import com.sj.model.Message;
import com.sj.statics.StaticConfigs;
import com.sj.service.api.ActivityService;
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
    KafkaTemplate<String, Message> template;

    public Activity savePlan(Activity activity) throws Exception {
        //数据库保存方案
        mapper.savePlan(activity);
        //通过kafka推送,放到消息队列中可多个消费者获取
        /*
          推送
         */
        Message message = new Message();
        message.setMsgCode(CODE.PUSH_ACTIVITY.getValue());
        message.setObj(activity);
        // 设置要发送到哪个具体的topic,根据类型
        template.setDefaultTopic(activity.getActivityType());
        // 根据key，在接收方过滤
        template.sendDefault(message.getMsgCode(), message);
        template.flush();
        return activity;
    }

    @Override
    public Activity modifyActivity(Activity activity) throws Exception {
        return null;
    }
}
