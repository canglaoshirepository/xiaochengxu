package com.cang.teacher;

import com.cang.FeignCommon;
import com.cang.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(FeignCommon.TEACHER_FEIGN)
public interface ITeacherFeignClient {

    @PostMapping("/teacher/selectAll")
    List<TeacherDTO> selectAll();

}
