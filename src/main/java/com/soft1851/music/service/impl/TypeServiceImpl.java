package com.soft1851.music.service.impl;

import com.soft1851.music.entity.Type;
import com.soft1851.music.dao.TypeDao;
import com.soft1851.music.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/5
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    @Override
    public List<Type> selectAllType() {
        return typeDao.selectAllType();
    }
}
