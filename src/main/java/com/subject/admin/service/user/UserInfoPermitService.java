package com.subject.admin.service.user;

import com.subject.admin.dto.user.PermitDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单
 */
public interface UserInfoPermitService {
    /**
     * 获取当前用户的所有菜单的权限
     * @param id
     * @return
     */
    public Map<String,Object> queryUserPermits(@Param("id") String id);

    /**
     * 查询客户的菜单权限
     * @param userId 用户id
     * @return 客户权限
     */
    public List<PermitDTO> queryUserPermitsByUserId(@Param("userId") String userId);
}
