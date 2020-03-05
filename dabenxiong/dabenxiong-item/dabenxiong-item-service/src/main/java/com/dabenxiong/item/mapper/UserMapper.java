package com.dabenxiong.item.mapper;

import com.dabenxiong.item.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 一只大笨熊
 * @create 2020-02-24 7:01
 */
public interface UserMapper extends Mapper<User> {
    @Insert("INSERT INTO tb_user (uid,username,userpassword,states,registdate,remarks,authorid) values (#{num},#{username},#{userpassword},#{states},#{registdate},#{remarks},#{authorid})")
    int saveUser(@Param("num")Integer num,@Param("username") String username, @Param("userpassword") String userpassword, @Param("states") String states, @Param("registdate") String registdate, @Param("remarks") String remarks,@Param("authorid")Integer authorid);

    @Update("UPDATE tb_user SET username=#{username},userpassword=#{userpassword},states=#{states},remarks=#{remarks} WHERE uid=#{uid} AND authorid=#{authorid}")
    int updateUser(@Param("username") String username, @Param("userpassword") String userpassword, @Param("states") String states, @Param("remarks") String remarks,@Param("uid")Integer uid,@Param("authorid")Integer authorid);


}
