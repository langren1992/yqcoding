package com.anserx.yqcoding.common.exception;

import com.anserx.yqcoding.common.util.ExceptionUtils;
import com.anserx.yqcoding.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @class GlobalExceptionHandler
 * @description 全局异常类型处理器
 *
 * @author zengrui
 * @datetime 2020-06-23 22:22
 * @version 1.0
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public Result<String> nullPointerException(HttpServletRequest request, HttpServletResponse response, NullPointerException ex){
        log.error("空指针异常：{}", ExceptionUtils.getStackTrace(ex.fillInStackTrace()));
        return new Result<String>().error("空指针异常",request.getServletPath());
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result<String> businessException(HttpServletRequest request,HttpServletResponse response, BusinessException ex){
        log.error("业务异常：{}", ExceptionUtils.getStackTrace(ex.fillInStackTrace()));
        return new Result<String>().error("业务异常",request.getServletPath());
    }
}
