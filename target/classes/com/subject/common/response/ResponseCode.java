package com.subject.common.response;

/**
 * 返回错误码标识
 * @ClassName: ResponseCode
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/8 13:58
 */
public final class ResponseCode {

   public static final String L00000 = "L00000";
   public static final String L00000_MSG = "成功！";
   public static final String L99999 = "L99999";
   public static final String L99999_MSG = "失败！";


    public static final String L00001 = "L00001";
    public static final String L00001_MSG = "客户信息不存在，请查证后再登录或者重新注册！";
    public static final String L00002 = "L00002";
    public static final String L00002_MSG = "密码不正确，请重新输入！";
    public static final String L00003 = "L00003";
    public static final String L00003_MSG = "账号或者密码不能为空！";
    public static final String L00004 = "L0004";
    public static final String L00004_MSG = "请输入正确的%s！";
    public static final String L00005 = "L0005";
    public static final String L00005_MSG = "已登录是否已此次登录为准";
}
