package com.djcao.sell.spring.applicationcontext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/30
 */
@Aspect
public class AspectjTest {

    @Pointcut("execution(* com.djcao.sell.spring.beanfactory.Person.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("################");
        System.out.println(joinPoint.getSignature().getName());
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("______________________________");
        System.out.println(joinPoint.getSignature().getName());
    }

}
