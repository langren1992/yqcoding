package com.anserx.yqcoding.admin.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.anserx.yqcoding.common.filter.ValueDesensitizeFilter;
import com.anserx.yqcoding.common.format.DesensitizedAnnotationFormatterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("启用自定义注解！！！");
        // 对请求参数进行脱敏操作
        registry.addFormatterForFieldAnnotation(new DesensitizedAnnotationFormatterFactory());
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializeFilters(new ValueDesensitizeFilter());//添加自己写的拦截器

        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypeList=new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(mediaTypeList);
        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

}
