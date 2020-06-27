package com.anserx.yqcoding.common.enums;

/**
 * 
 * @class CommonErrorEnum
 * @description 通用异常类型定义
 *
 * @author zengrui
 * @datetime 2020-06-20 12:53
 * @version 1.0
 **/
public enum CommonErrorEnum implements BaseEnum<Integer,String> {

    /**
     * 200
     */
    OK(200, "成功"),
    /**
     * 400
     */
    BED_REQUEST(400,"请求错误"),
    /**
     * 400
     */
    UNAUTHORIZED(401,"没有权限"),
    /**
     * 403
     */
    FORBIDDEN(403,"请求拒绝"),
    /**
     * 404
     */
    NOT_FOUND(404,"资源不存在"),
    /**
     * 405
     */
    METHOD_NOT_ALLOWED(405, "请求方式错误"),
    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(500, "服务异常"),
    /**
     * 501
     */
    KACPCHAR_ERROR(501, "验证码异常")
    ;


    private Integer key;

    private String value;

    CommonErrorEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @method resolve
     * @description 通过key查询枚举值 （转换名称）
     *
     * @author zengrui
     * @date 13:30 13:30
     * @param: statusCode
     * @return com.anserx.yqcoding.common.core.enums.CommonErrorEnum
     **/ 
    public static CommonErrorEnum resolve(int statusCode) {
        for (CommonErrorEnum status : values()) {
            if (status.key == statusCode) {
                return status;
            }
        }
        return null;
    }
}
