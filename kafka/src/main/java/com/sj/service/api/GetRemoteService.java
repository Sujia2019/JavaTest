package com.sj.service.api;

import com.sj.model.Message;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 从kafka消息队列中拿服务事件
 */
@Service
public abstract class GetRemoteService<T> {
    @Resource(name = "consumerProps")
    public Map<String, Object> propsMap;


    /**
     * 获取
     *
     * @return
     */
    public abstract T get();

    /**
     * 处理消息
     *
     * @return
     */
    public abstract Object handle(T msg);

    /**
     * 设置容器属性
     *
     * @param listener 监听方法
     * @return
     */
    public abstract ContainerProperties setContainerProps(MessageListener<String, T> listener);

    public abstract MessageListener<String, T> setMessageListener();

    //消费者监听容器
    protected KafkaMessageListenerContainer<Integer, String> createContainer(
            ContainerProperties containerProps) {
        Map<String, Object> props = propsMap;
        DefaultKafkaConsumerFactory<Integer, String> cf =
                new DefaultKafkaConsumerFactory<Integer, String>(props);
        KafkaMessageListenerContainer<Integer, String> container =
                new KafkaMessageListenerContainer<>(cf, containerProps);
        return container;
    }

}
