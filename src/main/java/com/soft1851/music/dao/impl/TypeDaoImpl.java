package com.soft1851.music.dao.impl;

import com.soft1851.music.dao.TypeDao;
import com.soft1851.music.entity.MusicVo;
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

    @Override
    public List<MusicVo> selectMusicByType(Integer typeId) {
        String sql = "SELECT t1.type_name,t2.music_name,t2.url,t2.singer FROM t_type t1 LEFT JOIN t_music t2 ON t1.id = t2.type WHERE t1.id = ?";
        Object[] args = {typeId};
        return jdbcTemplate.query(sql,args,new BeanPropertyRowMapper<>(MusicVo.class));
    }
}
