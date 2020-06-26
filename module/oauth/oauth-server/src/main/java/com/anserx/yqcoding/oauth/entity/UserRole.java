package com.anserx.yqcoding.oauth.entity;
import com.anserx.yqcoding.common.core.entity.LogEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 用户角色信息 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("oauth_user_role")
public class UserRole extends LogEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    /**
     * 公司ID
     */
    private Long companyId;

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFIER = "modifier";

    public static final String MODIFY_TIME = "modify_time";

    public static final String STATUS = "status";

    public static final String VERSION = "version";

    public static final String DELETED = "deleted";

    public static final String COMPANY_ID = "company_id";

}
