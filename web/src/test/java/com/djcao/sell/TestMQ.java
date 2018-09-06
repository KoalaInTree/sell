package com.djcao.sell;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-06
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Application.class)
@RunWith(SpringRunner.class)
public class TestMQ {

    @Value("${rocketmq.consumer.topic}")
    private String topic;
    @Value("${rocketmq.consumer.tag}")
    private String tag;
    @Autowired
    private DefaultMQProducer producer;

    @Test
    public void testSycSendMessage(){
        Message message = new Message();
        message.setTopic(topic);
        message.setTags(tag);
        message.setBody("hello,rocketmq".getBytes());
        try {
            SendResult send = producer.send(message);
            System.out.println(send);
            Thread.sleep(3000);
            System.out.println("weak up");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
