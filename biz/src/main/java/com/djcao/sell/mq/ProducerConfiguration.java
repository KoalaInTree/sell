package com.djcao.sell.mq;

import lombok.Data;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/5
 */
@Data
@ConfigurationProperties(prefix = "rocketmq.producer")
@SpringBootConfiguration
public class ProducerConfiguration {
    private String groupName;
    private String namesrvAddr;
    private String instanceName;
    private String topic;
    private String tag;
    private int maxMessageSize;
    private int sendMsgTimeout;

    @Bean
    public DefaultMQProducer init(){
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName(instanceName);
        producer.setSendMsgTimeout(sendMsgTimeout);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }


}
