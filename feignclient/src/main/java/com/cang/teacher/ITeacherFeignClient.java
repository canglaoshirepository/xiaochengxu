package com.cang.teacher;

import com.cang.FeignCommon;
import com.cang.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(FeignCommon.TEACHER_FEIGN)
public interface ITeacherFeignClient {

    @RequestMapping(method = RequestMethod.POST)
    List<TeacherDTO> selectAll();

}
