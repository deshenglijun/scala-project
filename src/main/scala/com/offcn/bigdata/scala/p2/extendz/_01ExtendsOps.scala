package com.offcn.bigdata.scala.p2.extendz

/**
 * 继承体系，
 *  表达的是类和类之间的从属关系，或者依赖关系，继承或者扩展，在ajva和scala中都是用关键字extends来表示
 *
 */
object _01ExtendsOps {
    def main(args: Array[String]): Unit = {
        val stu = new Student()
        stu.show()
    }
}
class Person {
    private var name: String = _
    protected var age: Int = 0
    def this(name: String, age: Int) {
        this()
        this.name = name
        this.age = age
    }
    def show(): Unit = {
        println(s"name: $name, age: $age")
    }
}
class Student extends Person {
    age = 15
    def this(age: Int) {
        this()
        this.age = age
    }
    //在scala中要想完成对父类方法的覆盖，必须要添加override关键字，反之则认为是一个新的方法，很有可能会造成方法名冲突，而报错
    override def show(): Unit = {
        super.show()
        println(s"发扬光大")
    }
}