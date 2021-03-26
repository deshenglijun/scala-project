package com.offcn.bigdata.scala.p1

/**
 * scala中的循环
 *  和java一样，也有while、do。。while、for循环
 *  while
 *
 *  需求：1+。。。+10
 *  java：
 *      int i = 1;
 *      int sum = 0;
 *      while(i <= 10) {
 *          sum = sum + i;
 *          i++;
 *      }
 *   scala的写法和java一模一样
 *  注意：因为想++/--在scala中是集合的操作，所以并不是想java一样为int类型的自增或者自减的操作，这里需要注意。
 */
object _02WhileLoopDemo {
    def main(args: Array[String]): Unit = {
        var i = 1
        var sum = 0
        while(i <= 10) {
            sum += i
            i += 1
        }
        println("sum: " + sum)
    }
}
