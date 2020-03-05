package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.pojo.RechargeRecord;
import com.dabenxiong.item.server.RechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 15:27
 */
@Controller
@RequestMapping("rechargerecord")
public class RechargeRecordController {

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @GetMapping("page")
    public ResponseEntity<PageResult<RechargeRecord>> queryRechargeRecordByauthorid(
            @RequestParam("authorid") Integer authorid
    ){
        PageResult<RechargeRecord> result =rechargeRecordService.queryRechargeRecordByauthorid(authorid);

        return ResponseEntity.ok(result);

    }





}
