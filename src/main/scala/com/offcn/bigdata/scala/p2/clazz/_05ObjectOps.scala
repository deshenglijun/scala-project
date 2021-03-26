package com.offcn.bigdata.scala.p2.clazz
/*
    object结构：是和class平级的语法结构，用来表示scala的一个类也可以拥有静态的结构。
    在scala中的class语法结构中，只能存在非静态的成员

    object的最重要的内容莫过于为scala的class提供静态的语法结构，实现java中的class既可以有静态，也可以有非静态的特点。
    其次也是scala程序执行的入口main方法之所在。

    至于前者，在scala中我们称之为伴生对象

    把在同一个scala源文件中相同名字的object和class互相成为：
        object是class的伴生对象
        class是object的伴生类
 */
object _05ObjectOps {
    def main(args: Array[String]): Unit = {
        val s1 = Singleton.getInstance()
        val s2 = Singleton.getInstance()
        println(s1 == s2)
    }
}

//单例
class Singleton private () {
    var x = 5
}
/* 饿汉式
object Singleton {
    private val instance = new Singleton
    def getInstance(): Singleton = {
        instance
    }
}
 */

object Singleton {
    private var instance:Singleton = _
    def getInstance(): Singleton = {
        if(instance == null) {
            Singleton.synchronized {
                if(instance == null) {
                    instance = new Singleton
                }
            }
        }
        instance
    }
}

