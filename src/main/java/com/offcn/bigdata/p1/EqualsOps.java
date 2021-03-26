package com.offcn.bigdata.p1;

public class EqualsOps {
    public static void main(String[] args) {
        Student s1 = new Student("卫超", 16);
        Student s2 = new Student("卫超", 16);
        System.out.println(s1.equals(s2));
    }
}
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * obj instanceof Student 把这种操作，称之为类型的检查或者类型的判断
     * Student that = (Student)obj;把这种操作，称之为类型的转换
     *  在java中称之为强制类型转换
     */
    @Override
    public boolean equals(Object obj) {
        if((obj == null) || !(obj instanceof Student)) return false;

        Student that = (Student)obj;
        return this.name.equals(that.name) && this.age == that.age;
    }
}
