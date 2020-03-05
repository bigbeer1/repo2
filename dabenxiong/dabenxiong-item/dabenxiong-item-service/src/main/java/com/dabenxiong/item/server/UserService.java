package com.dabenxiong.item.server;

import com.dabenxiong.common.pojo.AlgorithmCommon;
import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.mapper.UserMapper;
import com.dabenxiong.item.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 一只大笨熊
 * @create 2020-02-24 7:03
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询用户账号
     * @param username
     * @param states
     * @param startregistdate
     * @param endregistdate
     * @param remarks
     * @param pageIndex
     * @return
     */
    public PageResult<User> queryUsersByPage(Integer authorid,String username, String states, String startregistdate, String endregistdate, String remarks, Integer pageIndex) {
        //查询
       //初始化一个 Example对象
        Example example = new Example(User.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorid",authorid);

        //模糊查询用户名
        if (StringUtils.isNotBlank(username)){
            Example.Criteria criteria1 = example.createCriteria();
            criteria1.andLike("username","%"+username+"%");
            example.and(criteria1);
        };
        //根据状态states查询
        if (StringUtils.isNotBlank(states)){
            Example.Criteria criteria2 = example.createCriteria();
            criteria2.andEqualTo("states",states);
            example.and(criteria2);
        };
        //根据备注模糊查询
        if (StringUtils.isNotBlank(remarks)){
            Example.Criteria criteria3 = example.createCriteria();
            criteria3.andLike("remarks","%"+remarks+"%");
            example.and(criteria3);
        }
        //根据日期查询
        if (StringUtils.isNotBlank(startregistdate)&&StringUtils.isNotBlank(endregistdate)){
            Example.Criteria a = example.createCriteria();
            a.andBetween("registdate",startregistdate,endregistdate);
            example.and(a);
        };
        //添加分页
        PageHelper.startPage(pageIndex,10);

        //找到合适的通用Mapper方法
        List<User> users = this.userMapper.selectByExample(example);

        PageInfo<User> PageInfo = new PageInfo<>(users);

        return new PageResult<>(PageInfo.getTotal(),PageInfo.getList());

    }


    /**
     * 用户删除数据
     * @param uid
     */
    public void deleteUsersById(String uid) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",uid);
        userMapper.deleteByExample(example);

    }

    /**
     * 增加用户数据
     * @param username
     * @param userpassword
     * @param states
     * @param remarks
     * @param authorid
     */

    public void addUser(String username, String userpassword, String states, String remarks, Integer authorid) {
        Integer num = null;
        AlgorithmCommon algorithmCommon = new AlgorithmCommon();
        for(int i=0;i<6;i++){
            num = algorithmCommon.getNum(8);
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("uid",num);
            List<User> users = userMapper.selectByExample(example);
            if (users.isEmpty()){
                break;
            }
            if (i == 5){
                //错误暂时放置
                break;
            }
        }
        userMapper.saveUser(num,username,userpassword,states,algorithmCommon.Datetimenow(),remarks,authorid);
    }

//    public void saveUser(User user) {
//        userMapper.updateUser(user.getUsername(),user.getUserpassword(),user.getStates(),user.getRemarks(),user.getUid(),user.getAuthorid());
//    }


    public void saveUser(String username, String userpassword, String states,String remarks,Integer uid,Integer authorid) {


        int i = userMapper.updateUser(username, userpassword, states, remarks, uid, authorid);
        System.out.println(i);
    }


    public Boolean selectUserNamebyauthorid(Integer authorid, String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username).andEqualTo("authorid",authorid);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
