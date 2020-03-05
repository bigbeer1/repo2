package com.dabenxiong.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 7:37
 */
@Table(name="tb_software")
@Data
public class Software {
    @Id
    private Integer id;  //软件id
    private String softwarename;  //软件名称
    private String servicestate;  //软件服务状态
    private String safetycode;    //软件安全码
    private String registermode;  //注册模式
    private String version;     //版本号
    private String bindingmode;  //绑定模式
    private String trialmode;    //试用模式
    private String unbundingmode;   //解绑模式
    private String trialtime;   //试用时间
    private String updatemode;  //更新方式
    private String updateurl;  //更新地址
    private String verificationcode;  //验证码
    private String unbindingtime;  //解绑扣时
    private String registerdevtime;  //注册送时间
    private String softwarebulletin;  //软件公告
    private String customcode;   //自定义码
    private String staticdata;   //静态数据
    private String loginmode;  //登录模式
    private String moreopennumber;   //多开个数
    private Integer authorid;   //作者id


}
