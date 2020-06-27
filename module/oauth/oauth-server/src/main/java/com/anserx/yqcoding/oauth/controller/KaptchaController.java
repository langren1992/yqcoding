package com.anserx.yqcoding.oauth.controller;

import com.anserx.yqcoding.common.util.Result;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class KaptchaController {

    @Autowired
    private Producer producer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${kaptchaCode.timeout}")
    private Long kaptchaCodeTimeout;

    @RequestMapping("/createKaptcha")
    public Result<Map> createKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);
        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        //
        map.put("img", Base64.getEncoder().encodeToString(outputStream.toByteArray()));
        //生成验证码对应的token  以token为key  验证码为value存在redis中
        String codeToken = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(codeToken, text, kaptchaCodeTimeout, TimeUnit.MINUTES);
        map.put("kaptchaUuid", codeToken);
        return new Result<Map>().ok(map);
    }
}
