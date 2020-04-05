package com.soft1851.music.dao.impl;

import com.soft1851.music.dao.TypeDao;
import com.soft1851.music.entity.Type;
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
public class TypeDaoImpl implements TypeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Type> selectAllType() {
        String sql = "SELECT * FROM t_type";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Type.class));
    }
}
