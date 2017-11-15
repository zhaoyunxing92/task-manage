package com.sunny.task.service.unique.impl;


import com.sunny.task.mapper.unique.PrimaryKeyByUniqueIdMapper;
import com.sunny.task.model.unique.PrimaryKeyByUniqueId;
import com.sunny.task.service.unique.PrimaryKeyByUniqueIdService;
import com.sunny.task.utils.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunny
 * @className com.sunny.task.service.unique.impl.PrimaryKeyByUniqueIdServiceImpl
 * @date 2017-10-20 14:11
 * @description:
 */
@Service
public class PrimaryKeyByUniqueIdServiceImpl implements PrimaryKeyByUniqueIdService {
    @Autowired
    private PrimaryKeyByUniqueIdMapper primaryKeyByUniqueIdMapper;

    @Override
    public void addPrimaryKeyByUniqueId(String unqId, Long pkId,Byte type) {
        primaryKeyByUniqueIdMapper.insertSelective(new PrimaryKeyByUniqueId(unqId, pkId,type));
    }

    @Override
    public Long findPrimaryKeyByUniqueId(String unqId) {
        PrimaryKeyByUniqueId primaryKeyByUniqueId = primaryKeyByUniqueIdMapper.selectByPrimaryKey(unqId);
        if (NullUtils.isNull(primaryKeyByUniqueId)) {
            return 0L;
        }
        return primaryKeyByUniqueId.getPrimaryKey();
    }
}
