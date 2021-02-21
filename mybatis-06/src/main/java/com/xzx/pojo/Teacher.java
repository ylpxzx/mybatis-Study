package com.xzx.pojo;


import lombok.Data;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
@Data
public class Teacher {
    private int id;
    private String name;
//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "id=" + id +
//                ", name='" + name;
//    }
}
