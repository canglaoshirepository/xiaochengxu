package com.cang.controller;


import com.cang.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Api(tags = {"学生控制器"})
public class StudentController {

    @Resource(name = "StudentImpl")
    private IStudentService studentService;

    @ApiOperation("根据id查询学生名称")
    @PostMapping("/getById")
    public String getNameById(@RequestParam("id") Integer id){
        return studentService.getNameById(id);
    }
}
