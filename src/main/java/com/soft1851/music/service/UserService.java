package com.soft1851.music.service;

import com.soft1851.music.entity.User;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
public interface UserService {
    /**
     * 根据手机号和密码进行用户登录
     *
     * @param phoneNumber
     * @param password
     * @return user
     */
    List<User> phoneLogin(Integer phoneNumber, String password);

    /**
     * 根据邮箱和密码进行用户登录
     *
     * @param email
     * @param password
     * @return List<User>
     */
    List<User> emailLogin(String email, String password);
}
