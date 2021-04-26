package com.cang.student;

import com.cang.FeignCommon;
import com.cang.ResponseMessage;
import com.cang.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(FeignCommon.STUDENT_FEIGN)
@RestController
public interface StudentFeignClient {

    //@PostMapping("/student/selectAll")
    ResponseMessage<List<StudentDTO>> selectAll();
}
