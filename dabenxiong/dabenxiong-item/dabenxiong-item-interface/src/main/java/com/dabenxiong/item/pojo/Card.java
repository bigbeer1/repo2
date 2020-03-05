package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:55
 */
@Table(name="tb_card")
@Data
public class Card {
    @Id
    private Integer id;  //卡类id
    private Integer softwareid;  //软件id
    private String cardname;   //卡类名
    private String states;  //卡类状态
    private Integer hourtime;  //卡类时间
    private Integer price;  //价格
    private String cardtop;  //卡头
    private String remarks; //备注
    private Integer authorid;  //作者id


}
