package com.lihuanyu.controllers;

import com.lihuanyu.model.User;
import com.lihuanyu.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String password) {
        User user = null;
        try {
            user = new User(name, password);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }
}
