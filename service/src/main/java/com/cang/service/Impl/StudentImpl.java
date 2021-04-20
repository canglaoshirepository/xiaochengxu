package com.cang.service.Impl;

import com.cang.dao.IStudentMapper;
import com.cang.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentImpl")
@Slf4j
public class StudentImpl implements IStudentService {

    @Autowired
    private IStudentMapper studentMapper;
    @Override
    public String getNameById(Integer id) {
        String nameById = studentMapper.getNameById(id);
        return nameById;
    }
}
