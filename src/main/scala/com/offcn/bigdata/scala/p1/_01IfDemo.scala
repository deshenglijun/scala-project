package com.offcn.bigdata.scala.p1

/**
 * scala 流程控制之分支语句---if
 *  语法结构和java中的if非常相似，唯一的区别就在于scala中的if表达式有返回值，而java没有
 *
 *  if
 *  if。。else
 *  if..else if...else
 *
 */
object _01IfDemo {
    def main(args: Array[String]): Unit = {
        val score = 69.5f

        if(score > 60) {
            println("及格")
        } else {
            println("不及格")
        }
        println("---------------^_^--------------------")
        println("多分支语句")

        val result = if(score > 90) {
            "perfect"
        } else if(score > 80) {
            "fine"
        } else if(score > 70) {
            "middle"
        } else if(score >= 60) {
            60
        } else {
            "fail"
        }
        println(result)


    }
}
