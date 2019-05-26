package com.djcao.sell;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-05-26
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestCounterInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new RequestTimingInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
