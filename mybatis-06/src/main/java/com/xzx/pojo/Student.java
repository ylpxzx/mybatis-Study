package com.xzx.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    // 学生需要关联一个老师
    private Teacher teacher;
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", teacher='" + teacher + '\'' +
//                '}';
//    }
}
