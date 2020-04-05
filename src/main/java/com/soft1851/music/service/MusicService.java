package com.soft1851.music.service;

import com.soft1851.music.entity.Music;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
public interface MusicService {
    /**
     * 查询所有
     *
     * @return list<Music>
     */
    List<Music> selectAll();

    /**
     * 批量插入
     *
     * @param songs
     * @return int
     */
    int[] batchInsert(List<Music> songs);
}
