package com.cang.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
