package com.subject.common.config;

/**
 * 统一返回相应参数实体类
 * @author liugh 53182347@qq.com
 */

import java.io.Serializable;

public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = -1241360949457314497L;
    private T result;
    private String message;
    private String code;

    public ResponseModel() {
    }
    public ResponseModel(T result, String message, String code) {
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        return "ResponseModel [ result=" + this.result +  ", message=" + this.message + ", code=" + this.code + "]";
    }
}
