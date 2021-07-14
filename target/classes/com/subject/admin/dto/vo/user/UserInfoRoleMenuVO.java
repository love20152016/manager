package com.subject.admin.dto.vo.user;

import lombok.Data;

/**
 * 用户角色和菜单
 * @ClassName: UserInfoRoleMenuVO
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/8 10:12
 */
@Data
public class UserInfoRoleMenuVO {

    private String userId;

    private String account;

    private String userName;

    private String status;

    private String salt;

    private String email;

    private String mobile;

    private String roleId;

    private String roleName;

    private String remark;

    private String permitId;

    private String parentId;

    private String name;

    private String url;

    private String type;

    private String perms;

    private String orderNumber;
}
