package com.soft1851.music.dao;

import com.soft1851.music.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/2
 */
@Transactional(rollbackFor = Exception.class)
public interface UserDao {
    /**
     * 根据手机号和密码进行用户登录
     *
     * @param phoneNumber
     * @param password
     * @return user
     */
    List<User> phoneLogin(@Param("phoneNumber") Integer phoneNumber, @Param("password") String password);

    /**
     * 根据邮箱和密码进行用户登录
     *
     * @param email
     * @param password
     * @return List<User>
     */
    List<User> emailLogin(@Param("email") String email, @Param("password") String password);

    /**
     * 修改登录时间
     */
    void updateTime();
}

