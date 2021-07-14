package com.subject.admin.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 * @ClassName: RoleDTO
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/7 18:30
 */
@Data
public class RoleDTO implements Serializable {
    public RoleDTO(){}
    public RoleDTO(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    /**
     * id
     */
    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private String updateTime;
}
