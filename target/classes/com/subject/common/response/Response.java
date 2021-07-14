package com.subject.common.response;

import lombok.Data;

/**
 * 返回结果
 */
@Data
public class Response {

    // 状态码 100-成功 200-失败
    private String code;
    // 提示信息
    private String msg;

    // 用户要返回给浏览器的数据
    private Object data;

    /**
     * 构造公共调用的接口
     * @param code 编码
     * @param msg 描述
     * @param data 数据
     * @return 返回response
     */
    public static Response build(String code,String msg,Object data){
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
}
