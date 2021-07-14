package com.subject.admin.impl.user;

import com.subject.admin.dao.user.UserInfoMapper;
import com.subject.admin.dto.user.UserInfoDTO;
import com.subject.admin.service.user.UserInfoPermitService;
import com.subject.admin.service.user.UserInfoService;
import com.subject.common.response.Response;
import com.subject.common.response.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/7 17:29
 */
@Component("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoPermitService userInfoPermitService;

    @Autowired
    UserInfoMapper userInfoMapper;

    private static  final  String USER_ACCOUNT = "account";
    @Override
    public Response login(String account, String userNamePwd, String userView) {
        //参数校验
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(userNamePwd)){
            return Response.build(ResponseCode.L00003,ResponseCode.L00003_MSG,null);
        }
        //校验动态码
        if (!checkViewCode(userView)){
            return Response.build(ResponseCode.L00004, String.format(ResponseCode.L00004_MSG, "验证码"),null);
        }
        //获取当前客户数据
        UserInfoDTO userInfo = userInfoMapper.queryUserInfoBYAccount(account);
        if (null == userInfo){
           return Response.build(ResponseCode.L00001,ResponseCode.L00001_MSG,null);
        }
        //校验密码是否正确
        if (validUserPwd(userNamePwd,userInfo)){
            return Response.build(ResponseCode.L00001,ResponseCode.L00001_MSG,null);
        }
        //获取客户角色
        Map<String,Object> userInfoMap = userInfoPermitService.queryUserPermits(userInfo.getId());
        return Response.build(ResponseCode.L00002,ResponseCode.L00002_MSG,userInfoMap);
    }

    @Override
    public UserInfoDTO querUserInfo(String account) {
        //获取当前客户数据
        UserInfoDTO userInfo = userInfoMapper.queryUserInfoBYAccount(account);
        return userInfo;
    }

    /**
     * 校验用户的密码是否正确
     * @param pwd 输入的密码
     * @param userInfo 查询的客户信息
     * @return 返回
     */
    private boolean validUserPwd(String pwd,UserInfoDTO userInfo){
        //密码进行加密
        String pwdNew = "";
        if (pwd.equals(userInfo.getPassword())) {
          return true;
        }
        return false;
    }

    /**
     * 校验 动态码
     * @return
     */
    private boolean checkViewCode(String viewCode){

        return true;
    }

    /**
     * 校验客户是否登录
     * @param account 账号
     * @return 返回是否登录
     */
    private boolean checkUserAlreadyLogin(String account){

        return true;
    }
}
