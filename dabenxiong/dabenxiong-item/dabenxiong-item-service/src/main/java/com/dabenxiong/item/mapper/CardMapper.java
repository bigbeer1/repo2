package com.dabenxiong.item.mapper;

import com.dabenxiong.item.bo.CardBo;
import com.dabenxiong.item.pojo.Card;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:59
 */
public interface CardMapper extends Mapper<Card> {

    @Insert("INSERT INTO `tb_card` (`softwarename`,`cardname`,`state`,`hourtime`,`price`,`cardtop`,`remarks`) VALUES(#{softwarename},#{cardname},#{state},#{hourtime},#{price},#{cardtop},#{remarks})")
    int addCard(@Param("softwarename")String softwarename,@Param("cardname")String cardname,@Param("state")String state,@Param("hourtime")Long hourtime,@Param("price")Long price,@Param("cardtop")String cardtop,@Param("remarks")String sremarks);


    /**
     * 查询卡类数据
     * @param authorid
     * @return
     */
    @Select("SELECT a.id,b.softwarename,a.cardname,a.states,a.hourtime,a.price,a.cardtop,a.remarks  FROM tb_card a,tb_software b WHERE a.softwareid=b.id AND a.authorid=#{authorid}")
    List<CardBo> cardlistselect(@Param("authorid")Integer authorid);

}
