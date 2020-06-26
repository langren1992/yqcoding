package com.anserx.yqcoding.oauth.controller;

import com.anserx.yqcoding.common.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

/**
 * <p>
 * 用户信息  前端控制器
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/oauth/user")
public class UserController {

    @GetMapping("/get")
    public Result<Principal> getUserInfo(Principal user){
        return new Result<Principal>().ok(user);
    }

}
