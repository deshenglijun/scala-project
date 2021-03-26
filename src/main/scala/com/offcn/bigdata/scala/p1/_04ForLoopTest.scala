package com.offcn.bigdata.scala.p1

/**
 * for循环
 *   在java中的for循环，基本的有两种：普通for循环，foreach
 *   普通：
 *      for(初始化变量; 条件; 步进) {
 *          循环体
 *      }
 *   foreach：
 *      for(类型 变量： 集合) {
 *          循环体
 *      }
 *   scala的for循环和java的普通for循环差异比较大，或者就没有普通for循环，倒是和foreach相似：
 *      格式：
 *          for(变量 <- 集合) {
 *              循环体
 *          }
 *  将while循环中的操作，用for循环来一遍
 *
 *  scala中快速创建集合的方式，使用 数字 to/until 另外一个数字，比如：
 *  scala> 1 to 10
 *  res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *
 *  scala> 1 until 10
 *  res1: scala.collection.immutable.Range = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
 *  to生成的集合[]
 *  until生成的集合[)
 */
object _04ForLoopTest {
    def main(args: Array[String]): Unit = {
        var sum = 0
        for(i <- 1 to 10) {
            sum += i
        }
        println("for sum: " + sum)
    }
}
