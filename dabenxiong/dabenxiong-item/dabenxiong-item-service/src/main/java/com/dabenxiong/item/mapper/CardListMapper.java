package com.dabenxiong.item.mapper;

import com.dabenxiong.item.bo.CardListBo;
import com.dabenxiong.item.pojo.CardList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 13:47
 */
public interface CardListMapper extends Mapper<CardList> {

    /**
     * 查询卡密数据
     * @param authorid
     * @return
     */
    @Select("SELECT a.cid,b.softwarename,c.cardname,c.hourtime,a.cardmaketime,d.authorusername,a.cdkey,c.remarks,a.states " +
            "FROM tb_cardlist a,tb_software b,tb_card c,tb_author d WHERE a.softwareid=b.id AND a.cardid=c.id AND #{authorid}=d.id")
    List<CardListBo> CardListBoSelect(@Param("authorid")Integer authorid);
}
