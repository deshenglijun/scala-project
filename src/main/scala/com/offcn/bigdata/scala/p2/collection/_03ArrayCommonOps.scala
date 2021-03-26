package com.offcn.bigdata.scala.p2.collection

/**
 * 数组通用的操作
 *
 * 作业题：
 *      求数组：Array(1, 2, -3, 4, 5)，最大值和次大值
 */
object _03ArrayCommonOps {
    def main(args: Array[String]): Unit = {

        //判断
        var array = Array(1, 2, -3, 4, 5)
        println("array是否为空：" + array.isEmpty)
        println("是否包含元素3：" + array.contains(3))

        //数组和可变数组之间的转换
        //array --> arrayBuffer
        val ab = array.toBuffer
        //arrayBuffer --> array
        array = ab.toArray
        println("arrayBuffer是否为空：" + ab.isEmpty)
        println("是否包含元素-3：" + ab.contains(-3))

        //求和
        var sum = 0
        for(i <- array) {
            sum += i
        }
        println("sum: " + sum)
        println("array.sum: " + array.sum)
        println("array.max: " + array.max)
        println("array.min: " + array.min)
        var maxV = Int.MinValue

        for(i <- array) {
            if(i > maxV) {
                maxV = i
            }
        }
        println("---------------------------------")
        //diff intersect union distinct
        val left = Array(1, 2, 3, 4, 5, 1)
        val right = Array(3, 6, 1, 7, 9)
        //scala集合中的union相当于sql中的union all，不会去除重复
        println("union: " + left.union(right).mkString("[", ", ", "]"))
        //intersect 为两个集合的交集，即公共的部分
        println("intersect: " + left.intersect(right).mkString("[", ", ", "]"))
        //diff 为两个集合的差集，即A-B为A中存在而B中不存在的元素集合
        println("intersect: " + left.diff(right).mkString("[", ", ", "]"))
        //distinct
        println("distinct: " + left.distinct.mkString("[", ", ", "]"))




    }
}
