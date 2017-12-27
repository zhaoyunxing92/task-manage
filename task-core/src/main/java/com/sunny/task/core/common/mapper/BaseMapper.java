package com.sunny.task.core.common.mapper;


import com.sunny.task.core.common.model.BaseModel;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.mapper.BaseMapper
 * @date 2017-10-16 11:50
 * @description:
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {
    int deleteByPrimaryKey(ID id) throws Exception;

    // int insert(T record) throws TaskException;

    int insertSelective(T record) throws Exception;

    T selectByPrimaryKey(ID id) throws Exception;

    int updateByPrimaryKeySelective(T record) throws Exception;

    //int updateByPrimaryKey(T record) throws TaskException;
}
