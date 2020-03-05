package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.bo.UserSoftwareBo;
import com.dabenxiong.item.mapper.UserSoftwareMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-29 6:05
 */
@Service
public class UserSoftwareService {

    @Autowired
    public UserSoftwareMapper userSoftwareMapper;



    public PageResult<UserSoftwareBo> queryUserSoftwareBoByauthorid(Integer authorid) {

        List<UserSoftwareBo> userSoftwareBos=this.userSoftwareMapper.UserSoftwareBoSelect(authorid);
        PageHelper.startPage(1,10);
        PageInfo<UserSoftwareBo> userSoftwareBoPageInfo = new PageInfo<>(userSoftwareBos);
        return new PageResult<>(userSoftwareBoPageInfo.getTotal(),userSoftwareBoPageInfo.getList());

    }
}
