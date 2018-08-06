package com.djcao.sell.aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@Aspect
@Component
public class MapperAop {

    @Pointcut(value = "execution(* com.djcao.sell.db.mall.mapper.*.*(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.toString().concat("#####################################"));
    }

    @After(value = "pointcut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.toString().concat("#####################################"));
    }
}
