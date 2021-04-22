package com.cang;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseWrapper<T> implements Serializable {


    private String msg;
    private String code;
    private T t;

    public ResponseWrapper() {
    }

    public ResponseWrapper(String msg, String code, T data) {
        this.msg = msg;
        this.code = code;
        this.t = data;
    }

    public static <T> ResponseMessage<T> builder() {
        return new ResponseMessage<T>();
    }

    public static <T> ResponseMessage<T> ok(T t, String msg, String code) {
        return new ResponseMessage<T>().ok(msg, code, t);
    }



}
