package com.cang;


import lombok.Data;

import java.io.Serializable;


@Data
public class ResponseMessage<T> implements Serializable {
        private String msg;
        private String code;
        private T result;

        //public ResponseWrapper<T> build() {
      //      return new ResponseWrapper<T>(this.msg, this.code, this.result);
      //  }

        public ResponseMessage<T> ok( T t,String msg, String code) {
            this.msg = msg;
            this.code = code;
            this.result = t;
            return this;
        }
    }