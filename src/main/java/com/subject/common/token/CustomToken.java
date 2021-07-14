package com.subject.common.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName: CustomToken
 * @Description:
 * @Author: liaijun
 * @Date: 2021/4/23 16:19
 */
public class CustomToken extends UsernamePasswordToken {

    private String token;   //用户身份唯一的标识
    //这个token是在认证通过之后  用户访问其他资源的时候 来进行你给身份识别的

    public CustomToken(String token){
        this.token=token;
    }
    @Override
    public Object getPrincipal() {
        //在用户认证通过之后 再访问这个方法 默认返回的是什么?
        // Realm校验的第一个参数
        //校验我们自己写了   还有没有第一个参数这个说法?
        return token;
    }
}
