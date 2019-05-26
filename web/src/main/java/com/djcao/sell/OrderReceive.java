package com.djcao.sell;

import java.io.IOException;
import java.util.Map;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/21
 */
@Component("orderReceive")
public class OrderReceive {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void receive(){
        Message receive = rabbitTemplate.receive("order-queue");
        System.out.println(receive.toString());
    }

    @RabbitListener(
        bindings = @QueueBinding(
            exchange = @Exchange(type = ExchangeTypes.TOPIC,value = "order-exchange",durable = "true"),
            value = @Queue(value = "order-queue",durable = "true"),
            key = "order.#"
        )
    )
    @RabbitHandler
    public void onMessage(@Payload Object o, Channel channel, @Headers Map headers) throws IOException {
        System.out.println("######"+o.toString());
        channel.basicAck((Long)headers.get(AmqpHeaders.DELIVERY_TAG),false);
    }
}
