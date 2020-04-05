package com.soft1851.music.dao;

import com.soft1851.music.config.SpringDataSourceConfig;
import com.soft1851.music.entity.User;
import com.soft1851.music.service.UserService;
import com.soft1851.music.util.Md5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class UserDaoTest {
    @Resource
    private UserService userService;

    @Test
    public void phoneLogin() {
        int phoneNumber = 100010;
        String password = Md5.MD5("991214CYH");
        List<User> userList = userService.phoneLogin(phoneNumber, password);
        System.out.println(userList);
    }

    @Test
    public void emailLogin() {
        String email = "1797262364@qq.com";
        String password = Md5.MD5("991214CYH");
        List<User> userList = userService.emailLogin(email, password);
        System.out.println(userList);
    }
}