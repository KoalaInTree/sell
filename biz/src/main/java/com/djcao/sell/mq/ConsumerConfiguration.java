package com.djcao.sell.mq;

import java.util.List;


import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/5
 */
@Data
@ConfigurationProperties(prefix = "rocketmq.consumer")
@SpringBootConfiguration
public class ConsumerConfiguration {
    private String namesrvAddr;
    private String groupName;
    private String topic;
    private String tag;
    private int consumeThreadMin;
    private int consumeThreadMax;

    @Bean
    public DefaultMQPushConsumer init() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topic,tag);
        consumer.registerMessageListener((MessageListenerConcurrently)(list, consumeConcurrentlyContext) -> {
            list.forEach(messageExt -> {
                System.out.println(new String (messageExt.getBody()));
                if (messageExt.getTopic().equals(topic) && messageExt.getTopic().equals(tag)){
                    System.out.println(new String (messageExt.getBody()));
                }
            });

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();
        return consumer;
    }
}
