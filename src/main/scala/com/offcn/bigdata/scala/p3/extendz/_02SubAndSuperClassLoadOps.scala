package com.offcn.bigdata.scala.p3.extendz

/**
 * 学习子父类加载的过程
 *  1、因为scala中辅助构造器的特点是，第一句话必须要调用本类的构造器或者是其它的辅助构造器，那么久不可能再去调用父类的构造器
 *  2、所以要想完成利用父类的构造器进行成员初始化的时候，只能通过主构造器。
 *
 */
object _02SubAndSuperClassLoadOps {
    def main(args: Array[String]): Unit = {
        val programmer = new Programmer
        programmer.show()
    }
}
class Employee {

    println("这是父类worker的主构造器")

    var name: String = _
    var age: Int = _

    def this(name: String, age: Int) {
        this()
        this.name = name
        this.age = age
        println("这是父类worker的有参辅助构造器")
    }
    def show(): Unit = {
        println(s"name: ${name}, age: ${age}")
    }
}

class Programmer(name: String, age: Int) extends Employee(name, age) {

    println("这是子类Programmer的主构造器")
    var skill = "java, python, scala"

    def this() {
        this("刘国伟", 18)
        println("这是子类Programmer的有参辅助构造器")
    }
    override def show(): Unit = {
        super.show()
        println("i'm a coder, show me your code~")
    }

}