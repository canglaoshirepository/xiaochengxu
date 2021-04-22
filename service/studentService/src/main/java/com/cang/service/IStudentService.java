package com.cang.service;

import com.cang.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    String getNameById(Integer id);


    List<StudentDTO> selectAll();
}
