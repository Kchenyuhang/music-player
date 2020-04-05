package com.soft1851.music.controller;

import com.soft1851.music.entity.User;
import com.soft1851.music.service.UserService;
import com.soft1851.music.util.Result;
import com.soft1851.music.util.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
@Controller
@RequestMapping(value = "/")
public class UserLoginController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/phoneLogin")
    public Result userLogin(@RequestParam Integer phoneNumber, String password) {
        User user1 = new User();
        List<User> list = userService.phoneLogin(phoneNumber, password);
        if (list.size() != 0) {
            for (User user : list) {
                user1.setUserName(user.getUserName());
                user1.setPhoneNumber(user.getPhoneNumber());
                user1.setEmail(user.getEmail());
                user1.setCredits(user.getCredits());
                user1.setCreateTime(user.getCreateTime());
                user1.setLastLoginTime(user.getLastLoginTime());
            }
            return Result.success(user1);
        } else {
            return Result.failure(ResultCode.USER_LOGIN_FAILURE);
        }
    }
}
