package com.cang.controller;

import com.cang.ResponseMessage;
import com.cang.ResponseWrapper;
import com.cang.annotation.SaveLog;
import com.cang.dto.StudentDTO;
import com.cang.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api("学生控制器")
@RequestMapping("/student/")
@Slf4j
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private IStudentService studentService;


    @SaveLog
    @PostMapping("/getNameById")
    @ApiOperation("根据名称查询")
    public String getNameById(Integer id) {
        return studentService.getNameById(id);
    }


    @PostMapping("/selectAll")
    @SaveLog
    public ResponseMessage<List<StudentDTO>> selectAll() {
        //Object student = redisTemplate.opsForValue().get("student");
        return ResponseWrapper.ok(studentService.selectAll());
    }
}

