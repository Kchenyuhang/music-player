package com.soft1851.music.dao;

import com.soft1851.music.config.SpringDataSourceConfig;
import com.soft1851.music.entity.MusicVo;
import com.soft1851.music.entity.Type;
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
 * @Date 2020/4/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TypeDaoTest {
    @Resource
    private TypeDao typeDao;

    @Test
    public void selectAllType() {
        List<Type> typeList = typeDao.selectAllType();
        typeList.forEach(System.out::println);
    }

    @Test
    public void selectMusicByType() {
        int typeId=1;
        List<MusicVo> musicVos = typeDao.selectMusicByType(typeId);
        musicVos.forEach(System.out::println);
    }
}