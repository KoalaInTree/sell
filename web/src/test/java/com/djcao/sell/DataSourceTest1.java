package com.djcao.sell;

import java.util.List;

import com.djcao.sell.db.mall.domain.MmallUser;
import com.djcao.sell.db.mall.mapper.MmallUserMapper;
import com.djcao.sell.db.sell.domain.SellerInfo;
import com.djcao.sell.db.sell.mapper.SellerInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DataSourceTest1 {

    @Autowired
    private SellerInfoMapper sellerInfoMapper;

    @Autowired
    private MmallUserMapper mmallUserMapper;

    @Test
    public void testAdd(){
        List<SellerInfo> sellerInfos = sellerInfoMapper.selectAll();
        System.out.println(sellerInfos.size());

        List<MmallUser> mmallUserList = mmallUserMapper.selectAll();
        System.out.println(mmallUserList.size());

    }
}
