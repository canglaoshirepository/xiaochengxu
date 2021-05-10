package com.cang.service.impl;

import com.cang.dao.StudentMapper;
import com.cang.dto.StudentDTO;
import com.cang.service.IStudentService;
import com.cang.starter.teacher.ITeacherFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentDAO;

    @Resource
    private ITeacherFeignClient teacherFeignClient;

    @Override
    public String getNameById(Integer id) {
        return studentDAO.getNameById(id);
    }

    @Override
    public List<StudentDTO> selectAll() {
        System.out.println(teacherFeignClient.selectAll().toString());
        System.out.println("------>" + studentDAO.selectAll().toString());
        return studentDAO.selectAll();
    }
}
