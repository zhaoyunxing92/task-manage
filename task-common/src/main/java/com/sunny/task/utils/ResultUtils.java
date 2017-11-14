package com.sunny.task.utils;


import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.utils.ResultUtils
 * @date 2017-06-06 14:13
 * @description:
 */
public class ResultUtils {
    private ResultUtils() {
        super();
    }

    /**
     * @param resultEnum
     * @return
     */
    public static BaseResult success(ResultEnum resultEnum) {

        return success(resultEnum, null);
    }

    /**
     * @param msg
     * @param obj
     * @return
     */
    public static BaseResult success(String msg, Object obj) {
        BaseResult result = new BaseResult();
        result.setMsg(msg);
        result.setCode(0);
        result.setData(obj);
        return result;
    }

    /**
     * @param obj
     * @return
     */
    public static BaseResult success(Object obj) {
        BaseResult result = new BaseResult();
        result.setMsg("成功");
        result.setCode(0);
        result.setData(obj);
        return result;
    }

    /**
     * @return
     */
    public static BaseResult success() {
        BaseResult result = new BaseResult();
        result.setMsg("成功");
        result.setCode(0);
        //result.setData(obj);
        return result;
    }

    /**
     * @param msg
     * @return
     */
    public static BaseResult success(String msg) {
        BaseResult result = new BaseResult();
        result.setMsg(msg);
        result.setCode(0);
        //result.setData(obj);
        return result;
    }

    /**
     * @param resultEnum
     * @return
     */
    public static BaseResult success(ResultEnum resultEnum, Object obj) {
        BaseResult result = new BaseResult();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(obj);
        return result;
    }

    /**
     * 错误
     *
     * @param resultEnum
     * @return
     */

    public static BaseResult error(ResultEnum resultEnum) {
        BaseResult result = new BaseResult();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        // result.setData (null);
        return result;
    }

    /**
     * 错误
     *
     * @param resultEnum
     * @param errors
     * @return
     */
    public static BaseResult error(ResultEnum resultEnum, List<ObjectError> errors) {
        BaseResult result = new BaseResult();
        result.setMsg(resultEnum.getMsg() + errorsToString(errors));
        result.setCode(resultEnum.getCode());
        // result.setData (null);
        return result;
    }

    /**
     * 错误
     *
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult error(Integer code, String msg) {
        BaseResult result = new BaseResult();
        result.setMsg(msg);
        result.setCode(code);
        // result.setData (null);
        return result;
    }

    /**
     * @param errors
     * @return
     */
    public static String errorsToString(List<ObjectError> errors) {
        String errorsStr = "";
        if (errors.isEmpty() || null == errors) {
            return errorsStr;
        }
        for (ObjectError error : errors) {
            errorsStr += error.getDefaultMessage() + ",";
        }
        return errorsStr.substring(0, errorsStr.lastIndexOf(","));
    }
}
