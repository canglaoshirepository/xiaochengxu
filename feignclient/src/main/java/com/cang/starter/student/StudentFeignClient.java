package com.cang.starter.student;

import com.cang.FeignCommon;
import com.cang.ResponseMessage;
import com.cang.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(FeignCommon.STUDENT_FEIGN)
public interface StudentFeignClient {

    @PostMapping("/student/selectAll")
    ResponseMessage<List<StudentDTO>> selectAll();
}


