package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 5:50
 */
@Table(name="tb_usersoftware")
@Data
public class UserSoftware extends User{
    @Id
    private Integer id;  //用户软件id
    private Integer userid;  //用户id
    private Integer softwareid; //软件id
    private Integer authorid; //作者id
    private String mac;  //机器码
    private String online;  //在线状态
    private Date startdatetime;  //注册软件时间
    private Date enddatetime;  //软件到期时间
    private String privatedata;  //私有数据
}
