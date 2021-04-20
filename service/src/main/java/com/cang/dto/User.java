package com.cang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "用户基础信息返回结果")
public class User{
    @ApiModelProperty(name = "姓名")
    private String name;
    @ApiModelProperty(name = "年龄")
    private Integer age;
    public User(String name,Integer age){
        this.age = age;
        this.name = name;
    }
}
