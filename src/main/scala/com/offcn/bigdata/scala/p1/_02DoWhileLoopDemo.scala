package com.offcn.bigdata.scala.p1

/**
 * scala循环之do while循环
 *  do ... while
 *  需求：1+。。。+10
 *  java:
 *      int i = 1;
 *      int sum = 0;
 *      do {
 *          sum += i;
 *          i++;
 *      }while(i <= 10)
 */
object _02DoWhileLoopDemo {
    def main(args: Array[String]): Unit = {
        var i = 1
        var sum = 0
        do {
            sum += i
            i += 1
        } while (i <= 10)

        println("sum: " + sum)
    }
}
