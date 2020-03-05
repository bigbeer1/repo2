package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.CardBo;
import com.dabenxiong.item.server.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:59
 */
@Controller
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("add")
    public ResponseEntity<Void> addCard(
            @RequestParam(value = "softwarename",required = true) String softwarename,
            @RequestParam(value = "cardname",required = true) String cardname,
            @RequestParam(value = "state",required = true) String state,
            @RequestParam(value = "hourtime",required = true) Long hourtime,
            @RequestParam(value = "price",required = true) Long price,
            @RequestParam(value = "cardtop",required = false,defaultValue = "") String cardtop,
            @RequestParam(value = "remarks",required = false,defaultValue = "") String remarks
            ){
        this.cardService.addCard(softwarename,cardname,state,hourtime,price,cardtop,remarks);

        return ResponseEntity.ok().build();
    };

    /**
     * 查询卡类数据
     * @param authorid
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<CardBo>> queryCardByAuthorid(@RequestParam("authorid")Integer authorid){

        PageResult<CardBo> result=this.cardService.queryCardByAuthorid(authorid);
        return ResponseEntity.ok(result);
    }
}
