package com.subject.admin.dao.user;

import com.subject.admin.dto.user.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 客户新信息
 */
@Repository
public interface UserInfoMapper {

    /**
     * 查询客户--通过账号/id/username查找
     * @param account
     */
    public UserInfoDTO queryUserInfoBYAccount(@Param("account") String account);
}
