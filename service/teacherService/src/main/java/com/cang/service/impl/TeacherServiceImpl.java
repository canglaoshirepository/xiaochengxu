package com.cang.service.impl;

import com.cang.SexEnum;
import com.cang.dao.ITeacherMapper;
import com.cang.dto.TeacherDTO;
import com.cang.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Console;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private ITeacherMapper teacherMapper;
    @Override
    public List<TeacherDTO> selectAll() {
        List<TeacherDTO> teacherDTOS = teacherMapper.selectAll();
        if(!CollectionUtils.isEmpty(teacherDTOS)){
            teacherDTOS.forEach(item -> {
                Integer sex = item.getSex();
                if (sex == 1){
                    String sexName = SexEnum.FEMAL.getName();
                    item.setSexName(sexName);
                }else {
                    String name = SexEnum.MALE.getName();
                    item.setSexName(name);
                }
            });
        }
        return teacherDTOS;
    }
}
