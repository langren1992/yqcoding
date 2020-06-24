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
@TableName("oauth_refresh_token")
public class RefreshToken{

    private static final long serialVersionUID = 1L;

    private String tokenId;

    private Blob token;

    private Blob authentication;

    public static final String TOKEN_ID = "token_id";

    public static final String TOKEN = "token";

    public static final String AUTHENTICATION = "authentication";

}
