package com.dabenxiong.item.bo;

import com.dabenxiong.item.pojo.CardList;
import lombok.Data;

/**
 * @author 一只大笨熊
 * @create 2020-03-02 6:45
 */
@Data
public class CardListBo extends CardList {
    private String softwarename;
    private String cardname;
    private String hourtime;
    private String authorusername;
    private String remarks;
}
