package com.djcao.sell;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-05-26
 */
@Component
public class ConsulRegister {

    private static Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromString("172.16.91.129:8500")).build();
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
    @PostConstruct
    public void init() {
        AgentClient agentClient = consul.agentClient();

        String serviceId = "1";
        Registration service = ImmutableRegistration.builder()
            .id(serviceId)
            .name("myService")
            .port(8080)
            .check(Registration.RegCheck.ttl(5L)) // registers with a TTL of 5 seconds
            .tags(Collections.singletonList("tag1"))
            .meta(Collections.singletonMap("version", "1.0"))
            .build();

        agentClient.register(service);

        // Check in with Consul (serviceId required only).
        // Client will prepend "service:" for service level checks.
        // Note that you need to continually check in before the TTL expires, otherwise your service's state will be marked as "critical".
        scheduledThreadPool.scheduleAtFixedRate(() -> {
            try {
                agentClient.pass(serviceId);
            } catch (NotRegisteredException e) {
                e.printStackTrace();
            }
        },0,4,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(this::printHealthServiceTask,0,5, TimeUnit.SECONDS);
    }

    public void printHealthServiceTask(){
        HealthClient client = consul.healthClient();
        String name = "myService";
        //获取所有服务
        System.out.println(client.getAllServiceInstances(name).getResponse().size());

        //获取所有正常的服务（健康检测通过的）
        client.getHealthyServiceInstances(name).getResponse().forEach((resp) -> {
            System.out.println(resp);
        });
    }
}
