package com.soft1851.music.service.impl;

import com.soft1851.music.entity.Music;
import com.soft1851.music.dao.MusicDao;
import com.soft1851.music.service.MusicService;
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
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicDao musicDao;


    @Override
    public List<Music> selectAll() {
        return null;
    }

    @Override
    public int[] batchInsert(List<Music> songs) {
        return new int[0];
    }
}
