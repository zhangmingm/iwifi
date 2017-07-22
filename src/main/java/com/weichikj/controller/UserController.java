package com.weichikj.controller;

import com.weichikj.model.User;
import com.weichikj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 用户表操作controller demo
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user/getUserInfo
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
        }
        return user;
    }

    /**
     * http://localhost:8080/user/getUserByParam?name=曹操
     * @param param
     * @return
     */
    @RequestMapping("/getUserByParam")
    @ResponseBody
    public List<User> getUserByParam(User param) {
        List<User> user = userService.getUserByParam(param);
        if(user!=null){
            System.out.println("user.getName():"+user.size());
        }
        return user;
    }



}
