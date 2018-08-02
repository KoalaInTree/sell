package com.djcao.sell;

import com.djcao.sell.domain.SellerInfo;
import com.djcao.sell.mapper.SellerInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDB {

    @Autowired
    private SellerInfoMapper sellerInfoMapper;
    @Test
    public void testDB(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("asdasds");
        sellerInfo.setPassword("1232");
        sellerInfo.setUsername("sadasdsad");
        sellerInfoMapper.insert(sellerInfo);
    }
}
