package com.sj.service.get;

import com.sj.model.Activity;
import com.sj.model.Message;
import com.sj.service.api.GetRemoteService;
import com.sj.statics.StaticConfigs;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetRemoteActivity extends GetRemoteService<Message> {
    private static final Logger logger = LoggerFactory.getLogger(GetRemoteActivity.class);
    private KafkaMessageListenerContainer container;
    private ContainerProperties containerPro;

    @Autowired
    KafkaConsumer<String, Message> consumer;

    public GetRemoteActivity() {
        MessageListener<String, Message> messageListener = setMessageListener();
        containerPro = setContainerProps(messageListener);
        container = createContainer(containerPro);
    }


    @KafkaListener(topics = StaticConfigs.TOPIC_PUSH_ACTIVITY, groupId = "fc")
    public void batchConsumer(List<ConsumerRecord<?, ?>> records) {
        try {
            logger.info("batchConsumer接收到消息时间：{}", System.currentTimeMillis());
            for (ConsumerRecord<?, ?> record : records) {
                Optional message = Optional.ofNullable(record.value());
                if (message.isPresent()) {
                    String msg = (String) message.get();
                    logger.info("batchConsumer接收到消息信息：{}", msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message get() {
        container.setBeanName("testAuto");
        container.start();
        // TODO 如何拿Listener里的对象... 我想让kafka负责存储
        return null;
    }

    @Override
    public Object handle(Message msg) {
        Object o = msg.getObj();
        if (o instanceof Activity) {
            logger.info("========handler正在进行对游戏策划方案的修饰========");
            ((Activity) o).setActivityDescribe("handler正在进行对游戏策划方案的修饰");
        }
        return o;
    }

    //消费者监听容器
    @Override
    public ContainerProperties setContainerProps(MessageListener<String, Message> listener) {
        ContainerProperties containerProps = new ContainerProperties(
                StaticConfigs.TOPIC_PUSH_ACTIVITY); // 获取活动策划消息
        containerProps.setMessageListener(listener);
        this.containerPro = containerProps;
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
