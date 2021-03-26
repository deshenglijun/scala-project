package com.offcn.bigdata.scala.p1

/**
 * 循环的嵌套，循环操作中有循环
 * 这里以for循环为例进行说明
 *
 * *****
 * *****
 * *****
 * *****
 * *****
 */
object _05LoopNestDemo {
    def main(args: Array[String]): Unit = {
        for(i <- 1 to 5) {
           for(j <- 1 to 5) {
               print("*")
           }
           println()
        }
        println("--------三角形--------------")
        for(i <- 1 to 5) {
            for(j <- 1 to i) {
                print("*")
            }
            println()
        }
        println("--------99乘法口诀表--------------")
        for(i <- 1 to 9) {
            for(j <- 1 to i) {
                //print(j + "*" + i + "=" + (i * j) + "\t")
                //字符串插值的操作
                print(s"$j*$i=${i * j}\t")
            }
            println
        }
        println("--------for循环的其它嵌套--------------")
        for(i <- 1 to 9; j <- 1 to i) {
            print(s"$j*$i=${i * j}\t")
            if(i == j)
                println()
        }
        println("--------for循环的其它嵌套--------------")
        for(i <- 1 to 9; j <- 1 to 9 if(j <= i)) {
            print(s"$j*$i=${i * j}\t")
            if(i == j)
                println()
        }
    }
}
