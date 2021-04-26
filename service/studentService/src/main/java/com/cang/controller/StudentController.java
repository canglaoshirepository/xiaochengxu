package com.cang.controller;

import com.cang.ResponseMessage;
import com.cang.ResponseWrapper;
import com.cang.dto.StudentDTO;
import com.cang.service.IStudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Api("学生控制器")
@RequestMapping("/student/")
@Slf4j
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private TeacherController teacherController;


    @PostMapping("/getNameById")
    public String getNameById(Integer id){
       return studentService.getNameById(id);
    }


    @PostMapping("/selectAll")
    public ResponseMessage<List<StudentDTO>> selectAll(){
        logger.info("info");
        logger.warn("warn");
        //Object student = redisTemplate.opsForValue().get("student");
        List<StudentDTO> studentDTOS = studentService.selectAll();
        //redisTemplate.opsForValue().set("studeng",studentDTOS,60l, TimeUnit.SECONDS);
        return ResponseWrapper.ok(studentDTOS);
    }
}

