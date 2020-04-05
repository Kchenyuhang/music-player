package com.soft1851.music.dao;

import com.soft1851.music.entity.MusicVo;
import com.soft1851.music.entity.Type;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Transactional(rollbackFor = Exception.class)
public interface TypeDao {
    /**
     * 查询所有type
     * @return List<Type>
     */
    List<Type> selectAllType();

    /**
     * 根据type查询音乐
     * @return List<MusicVo>
     * @param typeId
     */
    List<MusicVo> selectMusicByType(Integer typeId);
}
