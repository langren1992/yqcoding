package com.anserx.yqcoding.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @description 异常处理工具类
 *
 * @author zengrui
 * @datetime   2020-06-23 18:34
 */
public class ExceptionUtils {

    /**
     *  异常消息
     * @param t 异常
     * @return 异常消息
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
