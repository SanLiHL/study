package com.study.springboot.mybatis.jojo;

/**
 * @Author liuhao
 * @Date 2023/2/7
 */
public class Dog implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
