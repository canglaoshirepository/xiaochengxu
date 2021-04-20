package com.cang.controller;

import com.cang.dto.TestDTO;
import com.cang.dto.User;
import com.cang.annotation.SaveLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Api(tags = {"用户控制器"})
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/getUsername")
    @ApiOperation("获取用户名")
    @SaveLog
    public void getUsername(){
        logger.info("info....");
        logger.debug("debug....");
        logger.warn("warn....");
        logger.error("error....");
        System.out.println(TestDTO.s);
        //throw new BussinessException("获取用户失败....");
    }

    @PostMapping("/getUserAge")
    @ApiOperation("获取用户年龄")
    @SaveLog
    public String getUserAge(){
        int i = 1/0;
        return "test...";
    }


    @PostMapping("/getUserByName")
    @ApiOperation("获取用户信息")
    public User getUserByName(@NotNull @RequestBody User user){
        return new User("张三",15);

    }
}
