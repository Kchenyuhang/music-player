package com.soft1851.music.service.impl;

import com.soft1851.music.entity.User;
import com.soft1851.music.dao.UserDao;
import com.soft1851.music.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> phoneLogin(Integer phoneNumber, String password) {
        return userDao.phoneLogin(phoneNumber,password);
    }

    @Override
    public List<User> emailLogin(String email, String password) {
        return userDao.emailLogin(email, password);
    }
}
