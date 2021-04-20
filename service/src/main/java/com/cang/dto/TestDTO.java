package com.cang.dto;

import org.springframework.beans.factory.annotation.Value;


public class TestDTO {
    public static String s;
    @Value("${com.cang.laoshi}")
    public void setName(String laoshi){
        this.s = laoshi;
    }
}
