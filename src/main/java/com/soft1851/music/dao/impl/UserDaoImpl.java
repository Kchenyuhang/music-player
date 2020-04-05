package com.soft1851.music.dao.impl;

import com.soft1851.music.dao.UserDao;
import com.soft1851.music.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> phoneLogin(Integer phoneNumber, String password) {
        String sql = "SELECT * FROM t_user WHERE phone_number = ? AND password = ?";
        Object[] args = {phoneNumber,password};
        return jdbcTemplate.query(sql,args,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> emailLogin(String email, String password) {
        String sql = "SELECT * FROM t_user WHERE email = ? AND password = ?";
        Object[] args = {email,password};
        return jdbcTemplate.query(sql,args,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void updateTime() {

    }
}
