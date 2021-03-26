package com.offcn.bigdata.scala.p2.clazz

/**
 * scala伴生对象的作用
 *  1、给伴生类提供了类似于java中的静态成员
 *  2、可以给scala的class提供一种新的对象构造方式
 *      在伴生对象中创建一个名为apply的方法，该apply方法的参数列表为class的构造函数的参数列表，二者保持对应
 *      返回值为本类，通过该apply方法来完成对象的构造
 */
object _06ObjectOps {
    def main(args: Array[String]): Unit = {
        val worker = Worker()
        worker.show()
        println("--------------")
        val w1 = Worker("柳泽宁", 15)
        w1.show()
    }
}
class Worker(name: String, age: Int) {
    def this() {
        this("old李", 35)
    }
    def this(name: String) {
        this()
    }
    def show(): Unit = {
        println(s"name: ${name}, age: ${age}")
    }
}
object Worker {//伴生对象
    def apply(): Worker = {
        new Worker()
    }
    def apply(name: String, age: Int): Worker = {
        new Worker(name, age)
    }
}