package com.soft1851.music.dao.impl;

import com.soft1851.music.dao.MusicDao;
import com.soft1851.music.entity.Music;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Repository
public class MusicDaoImpl implements MusicDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Music> selectAll() {
        return null;
    }

    @Override
    public int[] batchInsert(List<Music> songs) {
        final List<Music> songList = songs;
        String sql = "INSERT INTO t_music (music_name, type, url, singer) VALUES (?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Music song = songList.get(i);
                preparedStatement.setString(1,song.getMusicName());
                preparedStatement.setInt(2,song.getType());
                preparedStatement.setString(3,song.getUrl());
                preparedStatement.setString(4,song.getSinger());
            }

            @Override
            public int getBatchSize() {
                return songList.size();
            }
        });
    }
}
