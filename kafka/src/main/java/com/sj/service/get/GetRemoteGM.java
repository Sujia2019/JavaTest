package com.sj.service.get;

import com.sj.model.Message;
import com.sj.service.api.GetRemoteService;
import com.sj.statics.StaticConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListener;

public class GetRemoteGM extends GetRemoteService<Message> {
    private static final Logger logger = LoggerFactory.getLogger(GetRemoteActivity.class);
    @Override
    public Message get() {
        return null;
    }

    @Override
    public Object handle(Message msg) {
        return null;
    }

    @Override
    public ContainerProperties setContainerProps(MessageListener<String, Message> listener) {
        ContainerProperties containerProps = new ContainerProperties(
                StaticConfigs.TOPIC_PUSH_GM); // 获取系统推送消息
        containerProps.setMessageListener(listener);
        return containerProps;
    }

    @Override
    public MessageListener<String, Message> setMessageListener() {
        return msg -> {
            /*
             * 获取队列中的消息的方法
             */
            logger.info("receiver:---key:【{}】,value:【{}】", msg.key(), msg.value());
            //处理
            handle(msg.value());
        };
    }
}
