package com.offcn.bigdata.scala.p3.function

/**
 * scala 函数是编程操作
 *  函数：
 *      1、作为值的函数
 */
object _01FunctionOps {
    def main(args: Array[String]): Unit = {
//        funcOps1
//        funcOps2
        funcOps3
    }

    /**
     * 类比java/scala中学习过的这些匿名对象的用途，也都是通常只需要使用一次的地方来进行传递，
     * 通常都出现在方法的参数列表。
     * 因此，我们也可以大胆的推测，这个匿名函数，也应该用来作为一个(函数的)参数来使用。
     * scala中定义：一个函数的参数列表包含函数，或者该函数的返回值是一个函数，把这种函数称之为高阶函数(high level function)
     */
    def funcOps3: Unit = {
        /*
            showInfo是一个由两个参数的函数
                第一个形式参数为name，类型为String
                第二个形式参数为func，类型为(String) => Unit，这是一个匿名函数
         */
        def showInfo(name: String, func:(String) => Unit) = {
                func(name)
        }

        showInfo("王世伟", (name: String) => println( s"good bye to ${name}"))
        showInfo("王世伟", (str: String) => haha(str))
        //更优秀的写法
        showInfo("王世伟", (str) => haha(str)) //自动类型推断
        //从优秀到卓越 如果说，参数只有一个，是可以省略掉()
        showInfo("王世伟", n => haha(n))
        //从卓越到崩溃，最简我们还可以使用通配符(_)来完成参数的替代,也就是将n替换成_
        showInfo("王世伟", haha(_))
        //从崩溃到成仙， 当参数只有一个或者没有参数的时候，_也可以省略
        showInfo("王世伟", haha)
    }
    def haha(str: String): Unit = {
        println(str + ", 嘿嘿嘿~")
    }

    /**
     * 匿名函数: 没有函数名的函数，称之为匿名函数，
     *  匿名函数定义的语法结构上，和普通函数稍有差异：
     *   common function:
     *     def functionName(params): returnType = {}
     *   anonymous function:
     *      (params) => {}
     *
     */
    def funcOps2: Unit = {
        //匿名函数定义
        val sayBye = (name: String) => s"good bye to ${name}"

        println(sayBye("刘家豪"))
    }

    /**
     * 作为值的函数
     *  将一个函数作为值传递给另外一个变量或者函数定义
     *  传递给变量的时候，类似于java，直接赋值即可
     *  传递给函数的时候，需要在该函数后+空格和下划线，比如：
     *      def sayByeBye = sayGoodBye _
     */
    def funcOps1: Unit = {
        def sayGoodBye(name: String) = s"good bye to ${name}"
        val sgb = sayGoodBye("陈子涵")
        println(sgb)
        println("-------------------------")
        def sayByeBye = sayGoodBye _
        println(sayByeBye("田军洋"))
    }
}
