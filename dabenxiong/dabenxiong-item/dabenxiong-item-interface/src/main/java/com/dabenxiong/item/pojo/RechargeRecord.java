package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 15:19
 */
@Table(name="tb_recharge_record")
@Data
public class RechargeRecord {
    @Id
    private Integer id;  //充值记录id
    private String username;  //用户名
    private String softwarename;  //软件名
    private String authorusername;  //属于作者用户
    private Integer hourtime;  //充值时长
    private Date starthourtime;  //充值时间
    private Date endhourtime;  //结束时间
    private String cdkey; //卡密
    private String remarks;  //备注
    private Integer authorid;  //作者id

}
