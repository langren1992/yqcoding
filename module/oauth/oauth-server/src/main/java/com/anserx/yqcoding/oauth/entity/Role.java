package com.anserx.yqcoding.oauth.entity;
import com.anserx.yqcoding.common.core.entity.LogEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 角色信息 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("oauth_role")
public class Role extends LogEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

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

    public static final String CODE = "code";

    public static final String NAME = "name";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFIER = "modifier";

    public static final String MODIFY_TIME = "modify_time";

    public static final String STATUS = "status";

    public static final String VERSION = "version";

    public static final String DELETED = "deleted";

    public static final String COMPANY_ID = "company_id";

}
