package com.anserx.yqcoding.common.enums;

/**
 * 
 * @class EnableOrDisableEunm
 * @description 启用停用枚举
 *
 * @author zengrui
 * @datetime 2020-06-26 12:22
 * @version 1.0
 **/
public enum  EnableOrDisableEnum implements BaseEnum<Integer,String>{

    /**
     * 200
     */
    ENABLE(1, "启用"),
    /**
     * 400
     */
    DISABLE(0,"停用");
    
    private Integer key;
    
    private String value;

    EnableOrDisableEnum(int key, String value) {
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
    public static EnableOrDisableEnum resolve(int statusCode) {
        for (EnableOrDisableEnum status : values()) {
            if (status.key == statusCode) {
                return status;
            }
        }
        return null;
    }
}
