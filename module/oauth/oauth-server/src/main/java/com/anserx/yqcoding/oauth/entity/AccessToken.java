package com.anserx.yqcoding.oauth.entity;
import com.anserx.yqcoding.common.core.entity.LogEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Blob;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Data
@Accessors(chain = true)
@TableName("oauth_access_token")
public class AccessToken{

    private static final long serialVersionUID = 1L;

    private String tokenId;

    private Blob token;

    private String authenticationId;

    private String userName;

    private String clientId;

    private Blob authentication;

    private String refreshToken;

    public static final String TOKEN_ID = "token_id";

    public static final String TOKEN = "token";

    public static final String AUTHENTICATION_ID = "authentication_id";

    public static final String USER_NAME = "user_name";

    public static final String CLIENT_ID = "client_id";

    public static final String AUTHENTICATION = "authentication";

    public static final String REFRESH_TOKEN = "refresh_token";

}
