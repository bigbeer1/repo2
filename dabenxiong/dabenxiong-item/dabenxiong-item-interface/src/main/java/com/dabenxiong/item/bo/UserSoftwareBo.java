package com.dabenxiong.item.bo;

import com.dabenxiong.item.pojo.UserSoftware;
import lombok.Data;

/**
 * @author 一只大笨熊
 * @create 2020-03-02 10:50
 */
@Data
public class UserSoftwareBo extends UserSoftware {
    private String username;  //用户名
    private String softwarename; //软件名
    private String authorusername;  //归属管理
    private String states;  //用户状态
    private String remarks; //备注
}

