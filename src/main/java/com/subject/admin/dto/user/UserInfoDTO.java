package com.subject.admin.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserInfoDTO
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/7 17:41
 */
@Data
public class UserInfoDTO implements Serializable {

    public UserInfoDTO(){}
    public UserInfoDTO(String id, String account, String userName, String salt, String email, String mobile, String status) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.salt = salt;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
    }

    /**
     * id
     */
    private String id;
    /**
     * account
     */
    private String account;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String mobile;
    /**
     *  状态  0：禁用   1：正常 2 管控限制
     */
    private String status;
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
