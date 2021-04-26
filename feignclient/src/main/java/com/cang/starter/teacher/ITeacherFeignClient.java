package com.cang.starter.teacher;

import com.cang.FeignCommon;
import com.cang.ResponseMessage;
import com.cang.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(FeignCommon.TEACHER_FEIGN)
public interface ITeacherFeignClient {

    @RequestMapping(value = "/teacher/selectAll",method = RequestMethod.POST)
    ResponseMessage<List<TeacherDTO>> selectAll();

}
