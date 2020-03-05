package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.CardBo;
import com.dabenxiong.item.mapper.CardMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:59
 */
@Service
public class CardService {
    @Autowired
    private CardMapper cardMapper;

    public void addCard(String softwarename, String cardname, String state, Long hourtime, Long price, String cardtop, String remarks) {

        cardMapper.addCard(softwarename,cardname,state,hourtime,price,cardtop,remarks);


    }

    /**
     * 查询类卡数据
     * @param authorid
     * @return
     */
    public PageResult<CardBo> queryCardByAuthorid(Integer authorid) {
        List<CardBo> cardBos =cardMapper.cardlistselect(authorid);
        PageHelper.startPage(1,10);
        PageInfo<CardBo> cardPageInfo = new PageInfo<>(cardBos);
        return new PageResult<>(cardPageInfo.getTotal(),cardPageInfo.getList());
    }
}
