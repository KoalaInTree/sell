package com.djcao.sell.config;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-02
 */
@Data
@ConfigurationProperties(prefix = "job")
@Component
public class JobConfig {

    private String ip;

    private String port;

    private String appName;

    private String appSecret;

    private String redirectUrl;

    private Magic magic;
    @Data
    public static class Magic{
        private Boolean boolkey;
        private int intKey;
        private Integer atcKey;
        private Long longKey;

    }
}
