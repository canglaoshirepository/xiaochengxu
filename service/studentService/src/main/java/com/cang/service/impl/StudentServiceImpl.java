package com.cang.service.impl;

import com.cang.dao.StudentMapper;
import com.cang.dto.StudentDTO;
import com.cang.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentDAO;

    @Override
    public String getNameById(Integer id) {
        return studentDAO.getNameById(id);
    }

    @Override
    public List<StudentDTO> selectAll() {
        return studentDAO.selectAll();
    }
}
