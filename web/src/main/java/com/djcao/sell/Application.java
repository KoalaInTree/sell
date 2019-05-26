package com.djcao.sell;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
//@MapperScan("com.djcao.sell.mapper.**")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
