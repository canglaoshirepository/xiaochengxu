package com.cang.dao;

import com.cang.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentMapper {

    StudentDTO getNameById(Integer id);

    List<StudentDTO> selectAll();
}
