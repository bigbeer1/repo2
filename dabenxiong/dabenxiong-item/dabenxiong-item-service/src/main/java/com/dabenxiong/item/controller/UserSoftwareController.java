package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.UserSoftwareBo;
import com.dabenxiong.item.server.UserSoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:04
 */
@Controller
@RequestMapping("usersoftware")
public class UserSoftwareController {

    @Autowired
    public UserSoftwareService userSoftwareService;

    @GetMapping("page")
    public ResponseEntity<PageResult<UserSoftwareBo>> queryUserSoftwareBoByauthorid(
            @RequestParam("authorid") Integer authorid
    ){
        PageResult<UserSoftwareBo> result =this.userSoftwareService.queryUserSoftwareBoByauthorid(authorid);

        return ResponseEntity.ok(result);

    }




}
