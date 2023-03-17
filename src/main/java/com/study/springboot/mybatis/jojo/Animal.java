package com.study.springboot.mybatis.jojo;

/**
 * @Author liuhao
 * @Date 2023/2/7
 */
public class Animal implements Cloneable{
    private String name;
    private transient int age;
    private Dog eat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getEat() {
        return eat;
    }

    public void setEat(Dog eat) {
        this.eat = eat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
