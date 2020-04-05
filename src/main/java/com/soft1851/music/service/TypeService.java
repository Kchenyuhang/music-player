package com.soft1851.music.service;

import com.soft1851.music.entity.Type;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
public interface TypeService {
    /**
     * 查询所有type
     * @return List<Type>
     */
    List<Type> selectAllType();
}
