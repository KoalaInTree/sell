package com.djcao.sell;

import java.util.Map;

import com.djcao.sell.exception.TestException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map handle(Exception ex){
        Map map = Maps.newHashMap();
        map.put("code",500);
        map.put("message",ex.getMessage());
        return map;
    }

    @ExceptionHandler(value = TestException.class)
    @ResponseBody
    public Map handle(TestException t){
        System.out.println("捕获service异常".concat(t.getMessage()));
        Map map = Maps.newHashMap();
        map.put("code",500);
        map.put("message",t.getMessage());
        return map;
    }
}
