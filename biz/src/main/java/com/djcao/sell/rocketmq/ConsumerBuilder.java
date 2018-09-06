package com.djcao.sell.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-06
 */
@Data
@ConfigurationProperties(prefix = "rocketmq.consumer")
@SpringBootConfiguration
public class ConsumerBuilder {

    private String groupName;
    private String namesrvAddr;
    private String topic;
    private String tag;
    private int consumeThreadMax;
    private int consumeThreadMin;

    @Bean
    public DefaultMQPushConsumer init() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.subscribe(topic,tag);
        consumer.registerMessageListener((MessageListenerConcurrently)(list, consumeConcurrentlyContext) -> {
            System.out.println("收到消息###################################");
            list.forEach(messageExt -> {
                System.out.println(new String(messageExt.getBody()));
            });
            list.forEach(messageExt -> {
                if (topic.equals(messageExt.getTopic()) && tag.equals(messageExt.getTags())){
                    System.out.printf("接受配置的topic:{},tag:{}的消息，内容是:{}",topic,tag,new String(messageExt.getBody()));
                }
            });
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();
        return consumer;
    }
}
