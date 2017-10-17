package com.sunny.task.common.base;

import com.sunny.task.core.exception.TaskException;

import java.io.Serializable;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.mapper.BaseMapper
 * @date 2017-10-16 11:50
 * @description:
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {
    int deleteByPrimaryKey(ID id) throws TaskException;

    int insert(T record) throws TaskException;

    int insertSelective(T record) throws TaskException;

    T selectByPrimaryKey(ID id) throws TaskException;

    int updateByPrimaryKeySelective(T record) throws TaskException;

    int updateByPrimaryKey(T record) throws TaskException;
}
