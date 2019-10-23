package com.entity;

import com.dao.IEat;

/*
* 快捷键
* alt+enter ：自动加类加包
* alt+insert：封装
*
* */
public class people implements IEat {
    private String name;
    private int age;

    public people(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public people() {
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public void eat() {

    }
}
