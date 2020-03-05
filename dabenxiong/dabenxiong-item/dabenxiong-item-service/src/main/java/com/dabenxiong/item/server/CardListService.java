package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.CardListBo;
import com.dabenxiong.item.mapper.CardListMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 13:47
 */
@Service
public class CardListService {
    @Autowired
    private CardListMapper cardListMapper;

    /**
     *查询卡密数据
     * @param authorid
     * @return
     */
    public PageResult<CardListBo> queryCardListBoBYauthorid(Integer authorid) {

        List<CardListBo> cardListBos = cardListMapper.CardListBoSelect(authorid);
        PageHelper.startPage(10,1);
        PageInfo<CardListBo> cardListBoPageInfo = new PageInfo<>(cardListBos);

        return new PageResult<>(cardListBoPageInfo.getTotal(),cardListBoPageInfo.getList());
    }



}
