package com.offcn.bigdata.p1.generic;

import java.util.ArrayList;
import java.util.List;

/*
java中泛型定义的特点是：
    =左右两侧的泛型必须要相同，不能出现泛型之间的继承关系
 */
public class GenericOps4 {
    public static void main(String[] args) {
        List<Student> ps = new ArrayList<Student>();
//        ps.add(new Person());
        ps.add(new Student());
    }
    static class Person{}
    static class Student extends Person{}
    static class Teacher extends Person{}
}
