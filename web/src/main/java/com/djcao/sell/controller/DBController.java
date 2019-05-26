package com.djcao.sell.controller;

import javax.annotation.Resource;

import com.djcao.sell.db.flybird.domain.Comments;
import com.djcao.sell.db.flybird.mapper.CommentsMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/27
 */
@RestController
@RequestMapping("db")
public class DBController {

    @Resource
    private CommentsMapper commentsMapper;

    @RequestMapping("select/{id}")
    public @ResponseBody Comments select(@PathVariable(name = "id") Integer id){
        System.out.println();
        return commentsMapper.selectByPrimaryKey(id);
    }
}
