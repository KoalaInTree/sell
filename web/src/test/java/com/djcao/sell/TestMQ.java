package com.djcao.sell;


import com.djcao.sell.mq.ProducerConfiguration;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/5
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Application.class)
@RunWith(SpringRunner.class)
public class TestMQ {

    @Autowired
    private DefaultMQProducer producer;
    @Autowired
    private ProducerConfiguration producerConfiguration;

    @Test
    public void testSycSendMessage()  {
        Message message = new Message();
        message.setTopic(producerConfiguration.getTopic());
        message.setTags(producerConfiguration.getTag());
        message.setBody("hello,rocketmq,我是来自火星的".getBytes());
        SendResult send = null;
        try {
            send = producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(send);
    }

}
