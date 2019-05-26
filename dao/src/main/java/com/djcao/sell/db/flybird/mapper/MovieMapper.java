package com.djcao.sell.db.flybird.mapper;

import com.djcao.sell.db.flybird.domain.Movie;
import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer id);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);
}