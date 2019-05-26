package com.djcao.sell.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

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
@ConfigurationProperties(prefix = "rocketmq.producer")
@SpringBootConfiguration
public class ProducerBuilder {

    private String namesrvAddr;
    private String groupName;
    private int sendMsgTimeout;
    private int maxMessageSize;

    /*@Bean
    public DefaultMQProducer init() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setSendMsgTimeout(sendMsgTimeout);
        producer.setMaxMessageSize(maxMessageSize);
        producer.start();
        return producer;
    }*/
}
