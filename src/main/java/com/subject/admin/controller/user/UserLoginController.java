package com.subject.admin.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.subject.common.response.Response;
import com.subject.admin.service.user.UserInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserLoginController
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/7 15:51
 */
@RequestMapping("backUser")
@RestController
public class UserLoginController {

    private static final String USER_NAME_KEY = "userName";
    private static final String USER_PWD_KEY = "userNamePwd";
    private static final String USER_VIEW_KEY = "userView";

    @Autowired
    UserInfoService userInfoService;

     @RequestMapping(method = RequestMethod.POST,value = "/login")
     @ApiOperation(value = "用户登录", notes = "用户登录")
     public Response login(@ApiParam(value = "用户ID",required = true) @RequestBody JSONObject param){
         //todo 参数校验为空
        String userName = param.getString(USER_NAME_KEY);
        String userNamePwd = param.getString(USER_PWD_KEY);
        String userView = param.getString(USER_VIEW_KEY);
        return userInfoService.login(userName,userNamePwd,userView);
     }

}
