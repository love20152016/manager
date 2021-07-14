package com.subject.admin.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限
 * @ClassName: PermitDTO
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/7 18:33
 */
@Data
public class PermitDTO implements Serializable {

    public PermitDTO(){}
    public PermitDTO(String id, String parentId, String name, String url, String type, String orderNum,String perms) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.type = type;
        this.perms = perms;
        this.orderNum = orderNum;
    }

    /**
     * id
     */
    private String id;
    /**
     * 父节点
     */
    private String parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 菜单编码
     */
    private String code;
    /**
     * 授权
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private String type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单图标
     */
    private String orderNum;
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
