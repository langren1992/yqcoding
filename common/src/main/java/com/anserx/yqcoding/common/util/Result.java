package com.anserx.yqcoding.common.util;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @class Result
 * @description 结果定义
 *
 * @author zengrui
 * @datetime 2020-06-20 13:23
 * @version 1.0
 **/
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 200;
    /**
     * 消息内容
     */
    private String msg = "成功";
    /**
     * 响应数据
     */
    private T data;


    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 0 ? true : false;
    }

    public Result<T> error() {
        this.code = CommonErrorEnum.INTERNAL_SERVER_ERROR.getKey();
        this.msg = CommonErrorEnum.INTERNAL_SERVER_ERROR.getValue();
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = CommonErrorEnum.resolve(code).getValue();
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = CommonErrorEnum.INTERNAL_SERVER_ERROR.getKey();
        this.msg = msg;
        return this;
    }


}
