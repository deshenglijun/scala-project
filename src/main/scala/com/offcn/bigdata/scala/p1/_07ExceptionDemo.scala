package com.offcn.bigdata.scala.p1

import java.io.IOException

/**
 * scala基础语法之异常终止和懒加载
 *  scala中的异常体系是完全沿用java的异常体系，换句话说scala中的异常就是java中异常体系的子类
 *  但是在语法结构上略有差异
 *  java中有两种处理方式：
 *      throw 异常
 *      try{}catch(异常){}finally{}
 *  scala中也有两种处理方式：
 *      throw 异常
 *      try{}catch{异常处理}finally{}
 *  继承体系：
 *      Throwable
 *          Error   ：错误，无法进行异常处理，程序终止
 *          Exception：异常，是有挽救的机会的
 *              RuntimeException： 运行时处理，编译期不处理
 *              非运行时异常：       在编译期就要进行处理
 *
 *  关键字——lazy（懒加载或者延迟加载）
 *      被lazy修饰的变量有如下特点：只有当该变量第一次被调用的时候，才会进行初始化，负责只会记录语法知识的正确与否，不会检查逻辑是否正确
 */
object _07ExceptionDemo {
    def main(args: Array[String]): Unit = {
        try {
            lazy val i = 1 / 0
            println("俺老孙太难了~")
            println(i)
        } catch {
            case e:ArrayIndexOutOfBoundsException => {
                println(s"我Exception了：${e.getMessage}")
            }
            case ame:IOException => {
                println(s"我异常了：${ame.getMessage}")
            }
            case _ => {//_就可以理解为java中switch的default默认的处理情况
                println("就不信你能逃得出五指山")
            }
        }
        println("城市套路深，我要回农村")

        /*
            switch(xxx) {
                case AAA:
                    aaa
                    break;
                case BBB:
                    bbb
                    break;
                default:
                    ccc
                    break;
            }
         */


    }
}
