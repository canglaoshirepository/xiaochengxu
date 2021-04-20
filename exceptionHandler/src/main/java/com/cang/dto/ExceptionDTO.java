package com.cang.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExceptionDTO implements Serializable {
    private String errorMsg;
    private Integer errorCode;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
