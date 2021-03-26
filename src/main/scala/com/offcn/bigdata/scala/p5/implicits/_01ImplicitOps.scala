package com.offcn.bigdata.scala.p5.implicits

import com.offcn.bigdata.scala.p4.collection.Person

/**
 * 隐式转换
 *    是scala中一个非常强大的功能，会根据需要将以中类型自动的转化为其他的类型，从而让原有的类型具备了被转化类型的api，
 *    说白了也就是丰富了现有api。
 *    而这背后都是通过一个叫做隐式转换函数的东东来实现。
 *
 *    隐式转换函数的语法格式
 *
 *    implicit def source2Target(source: Source): Target = {
 *    }
 *    这里需要涉及到一个隐式转换关键字：implicit
 */
object _01ImplicitOps {
    def main(args: Array[String]): Unit = {
        val x:Int = 3.5
        println("x: " + x)

        val str: String = new Person("陈子涵", 15)

        println(str)
    }

    implicit def double2Int(d: Double): Int = d.intValue()

    implicit def person2String(person: Person): String = person.toString
}
