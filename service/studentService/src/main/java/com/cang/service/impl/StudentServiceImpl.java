package com.cang.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cang.dao.StudentMapper;
import com.cang.dto.BussinessException;
import com.cang.dto.StudentDTO;
import com.cang.service.IStudentService;
import com.cang.starter.teacher.ITeacherFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentDAO;

    @Resource
    private ITeacherFeignClient teacherFeignClient;

    @Override
    public String getNameById(Integer id) {
        StudentDTO studentDTO = studentDAO.getNameById(id);
        JSONArray jsonArray = JSONArray.parseArray(studentDTO.getName());
        List<Map> cfgList = JSONObject.parseArray(jsonArray.toJSONString(), Map.class);
        Map map = cfgList.stream().filter(item -> {
            String key = item.get("key").toString();
            if (key.endsWith("type") || key.startsWith("_") || key.startsWith("series")) {
                return true;
            } else {
                return false;
            }
        }).findFirst().orElse(null);
        if (!CollectionUtils.isEmpty(map)) {
            System.out.println("success");
        } else {
            throw new BussinessException("error");
        }

        // 2.
        Boolean flag = Boolean.FALSE;
        HashMap unitYAxisIndex = new HashMap();
        HashMap unitTypeMap = new HashMap();
        List<Map> unitTypes = new ArrayList();
        for (Map e : cfgList) {
            String key = e.get("key").toString();
            if (key.startsWith("yAxis")) {
                flag = true;
            }
            if (key.startsWith("series") && key.endsWith("data")) {
                unitTypes.add(e);
            }
            if (key.startsWith("series") && key.endsWith("yAxisIndex")) {
                Object formValue = e.get("formValue");
                if (formValue instanceof Map) {
                    unitYAxisIndex.put(e.get("key"), ((Map) formValue).get("value"));
                } else {
                    unitYAxisIndex.put(e.get("key"),
                            StringUtils.isEmpty(objToString(e.get("build_value"))) ? e.get("value") : e.get("build_value"));
                }
            }
        }


        Map<String, List<Map>> collect = cfgList.stream().collect(
                Collectors.groupingBy(x -> {
                    String key = x.get("key").toString();
                    return key.substring(0, key.indexOf('.', key.indexOf('.') + 1));
                })
        );

        return null;

    }

    private String objToString(Object object) {
        return object == null ? null : StringUtils.isEmpty(object.toString()) ? null : object.toString();
    }

    @Override
    public List<StudentDTO> selectAll() {
        System.out.println(teacherFeignClient.selectAll().toString());
        return studentDAO.selectAll();
    }
    
}
