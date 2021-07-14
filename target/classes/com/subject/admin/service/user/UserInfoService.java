package com.subject.admin.service.user;

import com.subject.common.response.Response;
import com.subject.admin.dto.user.UserInfoDTO;

public interface UserInfoService {
    /**
     * 后台--客户登录
     * @param userName
     * @param userNamePwd
     * @param userView
     */
    public Response login(String userName, String userNamePwd, String userView);

    /**
     * 查询客户信息
     * @param account 账号
     * @return 客户的信息
     */
    public UserInfoDTO querUserInfo(String account);
}
