package com.djcao.sell;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
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

    @Autowired(required = false)
    private OrderSender orderSender;
    @Autowired
    private OrderReceive orderReceive;

    @Test
    public void testSycSendMessage(){
        Message message = new Message();
        message.setTopic(topic);
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

    @Test
    public void testSend(){
        orderSender.sendOrder("1");
    }

    @Test
    public void testReceive(){
        orderReceive.receive();
    }

    @Test
    public void testOnMessage(){
    }
}
