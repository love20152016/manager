package com.subject.admin.service.user;

import com.subject.admin.dto.user.RoleDTO;

import java.util.List;

/**
 * 用户角色
 */
public interface UserInfoRoleService {
    /**
     * 查询客户的角色信息
     * @param account 账号
     * @return 角色列表
     */
    public List<RoleDTO> queryUserRole(String account);
}
