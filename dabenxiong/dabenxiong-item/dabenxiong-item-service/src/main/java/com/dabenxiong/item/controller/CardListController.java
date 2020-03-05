package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.CardListBo;
import com.dabenxiong.item.server.CardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 13:46
 */
@Controller
@RequestMapping("cardlist")
public class CardListController {

    @Autowired
    private CardListService cardListService;


    /**
     * 查询卡密数据
     * @param authorid
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<CardListBo>> queryCardListBoBYauthorid(
            @RequestParam("authorid") Integer authorid

    ){
        PageResult<CardListBo> result =this.cardListService.queryCardListBoBYauthorid(authorid);

        return ResponseEntity.ok(result);


    }




}


