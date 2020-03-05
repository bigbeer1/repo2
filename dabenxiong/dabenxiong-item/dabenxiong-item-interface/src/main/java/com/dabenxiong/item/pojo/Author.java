package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**  作者实体类
 * @author 一只大笨熊
 * @create 2020-03-01 5:39
 */
@Table(name="tb_author")
@Data
public class Author {
    @Id
    private Integer id;  //作者id   测试222
    private String authorusername;  //作者用户名
    private String authorpassword;  //作者密码



}
