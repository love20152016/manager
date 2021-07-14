package com.subject.admin.dao.permit;

import com.subject.admin.dto.user.PermitDTO;
import com.subject.admin.dto.vo.user.UserInfoRoleMenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限
 */
@Repository
@Mapper
public interface UserInfoPermitMapper {
    /**
     * 获取当前用户的所有菜单的权限
     * @param id
     * @return
     */
   public List<UserInfoRoleMenuVO> queryUserPermits(@Param("id") String id);

    /**
     * 获取当前用户的所有菜单的权限
     * @param userId 用户id
     * @return 菜单权限
     */
    public List<PermitDTO> queryUserPermitsByUserId(@Param("userId") String userId);


}
