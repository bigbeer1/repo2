package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 一只大笨熊
 * @create 2020-02-24 6:51
 */
@Table(name="tb_user")
@Data
public class User {
    @Id
    private Integer uid;  //用户uid
    private String username;  //用户名
    private String userpassword;  //用户密码
    private String states;   //用户状态
    private Date registdate;  //用户注册时间
    private String remarks;   //备注
    private Integer authorid;   //作者id

}
