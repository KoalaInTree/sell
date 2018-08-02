package com.djcao.sell.mapper;

import com.djcao.sell.domain.SellerInfo;
import java.util.List;

public interface SellerInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SellerInfo record);

    SellerInfo selectByPrimaryKey(String id);

    List<SellerInfo> selectAll();

    int updateByPrimaryKey(SellerInfo record);
}