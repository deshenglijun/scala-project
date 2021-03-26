package com.offcn.bigdata.scala.p2.clazz

import scala.beans.BeanProperty

/**
 * scala中的类似于java中的setter/getter操作
 *
 * scala系统中提供一个注解——@BeanProperty在成员上添加，会自动为成员提供类似于java中的setter/getter
 *
 * 但是有一个要求：就是如果添加了@BeanProperty的注解，那么该字段就不能被private进行修饰
 *
 * 实际上这些所有的操作，就是为了模拟java中的javabean，而javabean的一个主要的作用就是来封装、传递数据的，通常
 * 不会添加过多的行为在里面。
 * 所以在scala中，不适合用这种普通的class来完成数据的封装，也就是模拟javabean。
 * 在scala中，有一个专门的语法结构——case class(样例类)来专门的模拟java中的bean。
 */
object _02ClassOps {
    def main(args: Array[String]): Unit = {
        val person: Student = new Student()
        person.sleep()
    }
}

class Student {
    private var name: String = "孤独的牧羊人"

    @BeanProperty var age: Int = 120
    @BeanProperty
    val gender: String = "male"
    def sleep(): Unit = {
        println(s"名为${name}， 年龄为${age}的哥们儿正在呼呼大睡~")
    }
}
