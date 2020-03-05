package com.dabenxiong.item.controller;

import com.dabenxiong.common.pojo.PageResult;
import com.dabenxiong.item.pojo.User;
import com.dabenxiong.item.server.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @author 一只大笨熊
 * @create 2020-02-24 7:04
 */
@Controller
@RequestMapping("account")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询是用户名重复
     * @param authorid
     * @param username
     * @return
     */
    @GetMapping("username")
    public ResponseEntity<Void> selectUserNamebyauthorid(
            @RequestParam(value = "authorid",required = true)Integer authorid,
            @RequestParam(value = "username",required = false)String username
    ){
        //判断是否有这用户名 如果没有A=true 返回201  如果有 A=false 返回205
        Boolean a=this.userService.selectUserNamebyauthorid(authorid,username);
            if (a){
                return ResponseEntity.status(201).build();
            }else {
                return ResponseEntity.status(205).build();
            }

    }
    /**
     * 查询页面数据
     * @param username
     * @param states
     * @param startregistdate
     * @param endregistdate
     * @param remarks
     * @param pageIndex
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<User>> queryUsersByPage(
            @RequestParam(value = "authorid",required = true)Integer authorid,
            @RequestParam(value = "username",required = false)String username,
            @RequestParam(value = "states",required = false)String states,
            @RequestParam(value = "startregistdate",required = false) String startregistdate,
            @RequestParam(value = "endregistdate",required = false) String endregistdate,
            @RequestParam(value = "remarks",required = false)String remarks,
            @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex
    ){
        PageResult<User> result = this.userService.queryUsersByPage(authorid,username, states,startregistdate,endregistdate, remarks,pageIndex);
        if (result==null || CollectionUtils.isEmpty(result.getItems())){
            if (StringUtils.isEmpty(username)||StringUtils.isEmpty(states)||StringUtils.isEmpty(startregistdate)||StringUtils.isEmpty(endregistdate)||StringUtils.isEmpty(endregistdate)||StringUtils.isEmpty(remarks)){
                return ResponseEntity.ok(result);
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 删除用户数据
     * @param uid
     * @return
     */
    @DeleteMapping("delete")
    public  ResponseEntity<Void>  deleteUsersById(@RequestParam(value = "uid",required = true)String uid){
        this.userService.deleteUsersById(uid);
        return ResponseEntity.noContent().build();

    }

    /**
     * 添加用户数据
     * @param username
     * @param userpassword
     * @param remarks
     * @return
     */
    @PostMapping("add")
        public ResponseEntity<Void> addUser(
                @RequestParam(value = "username",required = true)String username,
                @RequestParam(value = "userpassword",required = true)String userpassword,
                @RequestParam(value = "states",required = true,defaultValue = "正常")String states,
                @RequestParam(value = "remarks",required = false)String remarks,
                @RequestParam(value = "authorid",required = true)Integer authorid
    ){
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(userpassword)||StringUtils.isEmpty(states)||authorid==null||username.equals("undefined")||userpassword.equals("undefined")||states.equals("undefined")){
            return ResponseEntity.notFound().build();
        }
        this.userService.addUser(username,userpassword,states,remarks,authorid);
        return ResponseEntity.noContent().build();
    };


    @PutMapping("save")
    public ResponseEntity<Void> saveUser(
            @RequestParam(value = "username",required = true)String username,
            @RequestParam(value = "userpassword",required = true)String userpassword,
            @RequestParam(value = "states",required = true)String states,
            @RequestParam(value = "remarks",required = false,defaultValue ="")String remarks,
            @RequestParam(value = "uid",required = true)Integer uid,
            @RequestParam(value = "authorid",required = true)Integer authorid
    )
    {
        if (remarks.equals("null")){
            remarks="";
        }
       this.userService.saveUser(username,userpassword,states,remarks,uid,authorid);
        return ResponseEntity.noContent().build();
    };



//    @PutMapping("save")
//
//    public ResponseEntity<Void> saveUser(
//          @RequestBody User user
//    )
//    {
//       this.userService.saveUser(user);
//        return ResponseEntity.noContent().build();
//    };


}
