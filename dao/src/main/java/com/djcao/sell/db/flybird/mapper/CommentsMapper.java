package com.djcao.sell.db.flybird.mapper;

import com.djcao.sell.db.flybird.domain.Comments;
import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    Comments selectByPrimaryKey(Integer id);

    List<Comments> selectAll();

    int updateByPrimaryKey(Comments record);
}