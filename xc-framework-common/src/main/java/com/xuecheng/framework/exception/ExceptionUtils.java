package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * 抛异常的工具类
 */
public class ExceptionUtils {
 
    //使用此静态方法抛出自定义异常
    public static void throwEx(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

}