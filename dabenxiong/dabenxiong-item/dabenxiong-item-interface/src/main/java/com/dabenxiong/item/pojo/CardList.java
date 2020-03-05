package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 13:47
 */
@Table(name="tb_cardlist")
@Data
public class CardList {
    @Id
    private Integer cid;  //卡密id
    private Integer softwareid;  //软件id
    private Integer cardid;  //卡类id
    private Date cardmaketime;  //卡密制作时间
    private String cdkey;   //卡密
    private String states;  //卡密状态
    private Integer authorid;  //作者id


}
