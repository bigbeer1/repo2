package com.dabenxiong.item.mapper;

import com.dabenxiong.item.bo.UserSoftwareBo;
import com.dabenxiong.item.pojo.UserSoftware;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:05
 */
public interface UserSoftwareMapper extends Mapper<UserSoftware> {

    @Select("SELECT a.`id`,b.`username`,c.`softwarename`,d.`authorusername`,a.`mac`,a.`online`,b.`states`,a.`startdatetime`,a.`enddatetime`,a.`privatedata`,b.`remarks`FROM tb_usersoftware a,tb_user b,tb_software c,tb_author d WHERE a.`authorid`=#{authorid}")
    List<UserSoftwareBo> UserSoftwareBoSelect(@Param("authorid") Integer authorid);
}
