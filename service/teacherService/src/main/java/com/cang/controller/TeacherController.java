package com.cang.controller;

import com.cang.ResponseMessage;
import com.cang.ResponseWrapper;
import com.cang.dto.TeacherDTO;
import com.cang.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/teacher")
@Api("老师控制器")
@RestController
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    @PostMapping("/selectAll")
    public ResponseMessage<List<TeacherDTO>> selectAll() {
        return ResponseWrapper.ok(teacherService.selectAll());
    }
}
