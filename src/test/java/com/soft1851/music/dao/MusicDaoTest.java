package com.soft1851.music.dao;

import com.soft1851.music.config.SpringDataSourceConfig;
import com.soft1851.music.entity.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class MusicDaoTest {
    @Resource
    private MusicDao musicDao;

    @Test
    public void selectAll() {
        List<Music> musicList = musicDao.selectAll();
        musicList.forEach(System.out::println);
    }

    @Test
    public void batchInsert() {
    }
}