package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.mapper.RechargeRecordMapper;
import com.dabenxiong.item.pojo.RechargeRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 15:27
 */
@Service
public class RechargeRecordService {

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    /**
     * 根据作者id 查询充值记录
     * @param authorid
     * @return
     */
    public PageResult<RechargeRecord> queryRechargeRecordByauthorid(Integer authorid) {

        Example example = new Example(RechargeRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorid",authorid);
        PageHelper.startPage(1,10);

        List<RechargeRecord> rechargeRecords = rechargeRecordMapper.selectByExample(example);

        PageInfo<RechargeRecord> rechargeRecordPageInfo = new PageInfo<>(rechargeRecords);

        return new PageResult<>(rechargeRecordPageInfo.getTotal(),rechargeRecordPageInfo.getList());

    }
}
