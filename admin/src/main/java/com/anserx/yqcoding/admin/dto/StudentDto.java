package com.anserx.yqcoding.admin.dto;

import com.anserx.yqcoding.common.annotation.Desensitization;
import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StudentDto {

    @Desensitization(type = SensitiveTypeEnum.CHINESE_NAME)
    private String chinaName;

    @Desensitization(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String mobilePhone;

    @Desensitization(type = SensitiveTypeEnum.CARNUMBER)
    private String carNumber;
}
