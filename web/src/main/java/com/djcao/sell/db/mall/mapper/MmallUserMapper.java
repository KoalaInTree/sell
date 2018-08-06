package com.djcao.sell.db.mall.mapper;

import com.djcao.sell.db.mall.domain.MmallUser;
import java.util.List;

public interface MmallUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MmallUser record);

    MmallUser selectByPrimaryKey(Integer id);

    List<MmallUser> selectAll();

    int updateByPrimaryKey(MmallUser record);
}