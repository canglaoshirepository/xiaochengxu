package com.cang;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseMessage<T> implements Serializable {
        private String msg;
        private String code;
        private T t;

        public ResponseMessage code(String code) {
            this.code = code;
            return this;
        }

        public ResponseMessage msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseMessage data(T t) {
            this.t = t;
            return this;
        }

        public ResponseWrapper build() {
            return new ResponseWrapper<T>(this.msg, this.code, this.t);
        }

        public ResponseMessage ok( T t,String msg, String code) {
            this.msg = msg;
            this.code = code;
            this.t = t;
            return this;
        }
    }