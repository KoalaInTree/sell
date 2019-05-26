package com.djcao.sell;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/21
 */
@Component("orderSender")
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Object o){
        rabbitTemplate.convertAndSend("order-exchange","order.create",o,new CorrelationData(String.valueOf(o.hashCode())));
    }

    public void receive(){
        Message receive = rabbitTemplate.receive("order-queue");
        System.out.println(receive.toString());
    }
}
