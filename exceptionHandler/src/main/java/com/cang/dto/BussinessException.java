package com.cang.dto;

public class BussinessException extends RuntimeException{

    private String msg;
    public BussinessException(String msg){
        super(msg);
        this.msg = msg;
    }
    public BussinessException(){

    }
    public ExceptionDTO getErrorMsg(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setErrorMsg(msg);
        exceptionDTO.setErrorCode(502);
        return exceptionDTO;
    }
}
