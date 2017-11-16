package com.sunny.task.handle;


import com.sunny.task.exception.TaskException;
import com.sunny.task.exception.TaskUserAuthException;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.utils.ResultUtils;
import org.apache.ibatis.binding.BindingException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.UnexpectedTypeException;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.handle.BugManageHandle
 * @date 2017-06-06 20:33
 * @description:
 */
@ControllerAdvice
public class TaskManageHandle {
    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TaskManageHandle.class);

    // MyBatisSystemException nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'open' in 'class com.sunny.bugmanage.project.org.ProjectForm
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, MyBatisSystemException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResult validExceptionHandle(Exception ex) {

        if (ex instanceof BindException) {
            BindException bingException = (BindException) ex;
            return ResultUtils.error(ResultEnum.PARAMETER_ERROR, bingException.getAllErrors());
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            return ResultUtils.error(ResultEnum.PARAMETER_ERROR, methodArgumentNotValidException.getBindingResult().getAllErrors());
        } else if (ex instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) ex;
            return ResultUtils.error(100, httpMessageNotReadableException.getMessage());
        } else {
            return ResultUtils.error(200, ex.getMessage());
        }
        /* else {
            throw new BugManageException(200, ex.getCause());
		}*/
    }

    @ExceptionHandler({TaskException.class, BindingException.class, UnexpectedTypeException.class, TransientDataAccessResourceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult ExceptionHandle(Exception ex) {
        if (ex instanceof BindingException) {
            BindingException bindingException = (BindingException) ex;
            return ResultUtils.error(100, bindingException.getMessage());
        } else if (ex instanceof UnexpectedTypeException) {   //没有对应的类型
            UnexpectedTypeException unType = (UnexpectedTypeException) ex;
            return ResultUtils.error(100, unType.getMessage());

        } else if (ex instanceof TransientDataAccessResourceException) {
            TransientDataAccessResourceException transientDataAccessResour = (TransientDataAccessResourceException) ex;
            return ResultUtils.error(100, transientDataAccessResour.getMessage());
        } else {
            TaskException bugManageException = (TaskException) ex;
            return ResultUtils.error(bugManageException.getCode(), bugManageException.getMessage());
        }

    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public BaseResult methodNotAllOwed(HttpRequestMethodNotSupportedException ex) {
        //Request method 'POST' not supported
        return ResultUtils.error(100, ex.getMessage());
    }

    /**
     * 401权限不足
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({TaskUserAuthException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public BaseResult TaskUserAuthException(Exception ex) {

        TaskUserAuthException taskUserAuthException = (TaskUserAuthException) ex;
        return ResultUtils.error(taskUserAuthException.getCode(), taskUserAuthException.getMessage());
    }
    //DuplicateKeyException

    /**
     * 401权限不足
     *
     * @param ex
     * @return 唯一键重复
     */
    @ExceptionHandler({DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult DuplicateKeyException(DuplicateKeyException ex) {
        String exMsg = ex.getMessage();
        logger.error("唯一键重复：{}", ex);
        return ResultUtils.error(ResultEnum.DUPLICATE_KEY_EXCEPTION, exMsg.substring(exMsg.indexOf("Duplicate entry"), exMsg.indexOf("for key")));
    }


}
