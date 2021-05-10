package com.cang;


public enum SexEnum {
    MALE(0,"男"),
    FEMAL(1,"女");
    private SexEnum(Integer id,String name){}
    private Integer sex;
    private String sexName;
    public String getName(){
        return sexName;
    }
    public Integer getId(){
        return sex;
    }

   // public void setMale(String sex)
}
