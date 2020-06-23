package com.anserx.yqcoding.common.exception;

/**
 * 
 * @class BusinessException
 * @description 业务异常类定义
 *
 * @author zengrui
 * @datetime 2020-06-23 22:28
 * @version 1.0
 **/
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
