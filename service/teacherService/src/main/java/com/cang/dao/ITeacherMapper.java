package com.cang.dao;

import com.cang.dto.TeacherDTO;

import java.util.List;

public interface ITeacherMapper {
    List<TeacherDTO> selectAll();
}
