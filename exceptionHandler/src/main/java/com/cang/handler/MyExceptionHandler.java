package com.cang.handler;

import com.cang.dto.BussinessException;
import com.cang.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常处理类
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDTO bussinessException(BussinessException bussinessException){
        return bussinessException.getErrorMsg();
    }



    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ExceptionDTO exceptionResult(Throwable e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setErrorMsg(e.getMessage());
        return exceptionDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionDTO exceptionResult(Exception e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setErrorMsg(e.getMessage());
        return exceptionDTO;
    }
}
