package com.cang.handler;

import com.cang.ResponseMessage;
import com.cang.ResponseWrapper;
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
    public ResponseMessage exceptionResult(Throwable e){
        return ResponseWrapper.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage exceptionResult(Exception e){
        return ResponseWrapper.error(e.getMessage());
    }

    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResponseMessage exceptionResult(ClassCastException e){
        return ResponseWrapper.error(e.getMessage());
    }
}
