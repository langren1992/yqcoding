package com.anserx.yqcoding.oauth.config;


import com.anserx.yqcoding.oauth.core.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import javax.sql.DataSource;

/**
 *
 * @class AuthorizationServerConfig
 * @description 认证服务配置
 *
 * @author zengrui
 * @datetime 2020-06-25 11:48
 * @version 1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    /**
     * mysql
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 权限控制器
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Redis
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * UserService 登录验证
     */
    @Autowired
    private DefaultUserService defaultUserService;

    @Autowired
    private WebResponseExceptionTranslator bootWebResponseExceptionTranslator;

//    @Autowired
//    private DefaultBasicAuthenticationFilter defaultBasicAuthenticationFilter;

    /**
     * token存储方式
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
            //支持把secret和clientid写在url上，否则需要在头上
            .allowFormAuthenticationForClients();
//        .addTokenEndpointAuthenticationFilter(defaultBasicAuthenticationFilter);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .authenticationManager(authenticationManager)
            .userDetailsService(defaultUserService)
            .tokenStore(tokenStore())
            .reuseRefreshTokens(false)
            .exceptionTranslator(bootWebResponseExceptionTranslator);
    }
}
