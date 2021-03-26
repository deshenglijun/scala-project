package com.offcn.bigdata.scala.p1

/**
 * scala function函数的定义操作
 */
object _08FunctionDemo {
    def main(args: Array[String]): Unit = {
        val a = 5
        val b = 6
        val sum = add(a, b)
        println("sum: " + sum)
        println("-----------无返回值的函数-------------")
        myPrint("who pa who")
    }
    def add(b: Int, a: Int) = {
        a + b
    }

    def myPrint(obj: Any) = {
        println(obj)
    }
}
