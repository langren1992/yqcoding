package com.anserx.yqcoding.common.exception;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import com.anserx.yqcoding.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @class FinalErrorController
 * @description 最终异常处理类
 *
 * @author zengrui
 * @datetime 2020-06-23 22:58
 * @version 1.0
 **/
@RestController
@Slf4j
public class FinalErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping(value = "/error")
    public Result<String> error(HttpServletRequest request, HttpServletResponse response) {
        CommonErrorEnum resolve = CommonErrorEnum.resolve(response.getStatus());
        log.error("异常编码：{}，异常描述：{}",resolve.getKey(),resolve.getValue());
        if (ObjectUtils.anyNotNull(resolve)){
            return new Result<String>().error(resolve,request.getServletPath());
        } else {
            return new Result<String>().error(request.getServletPath());
        }
    }
}
