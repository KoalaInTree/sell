package com.djcao.sell.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JobConfigTest {

    @Autowired
    private JobConfig jobConfig;

    @Test
    public void testGetConfigBean(){
        System.out.printf(jobConfig.toString());
    }
}