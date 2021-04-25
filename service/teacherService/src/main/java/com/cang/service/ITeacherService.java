package com.cang.service;

import com.cang.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> selectAll();
}
