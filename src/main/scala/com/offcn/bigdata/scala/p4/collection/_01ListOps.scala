package com.offcn.bigdata.scala.p4.collection

/**
 * scala集合体系学习之List
 *   List是一个又首部元素(head)和其余元素构成子集合List(tail)构成
 *   比如：List(1, 2, 3, 4, 5)
 *   该list的head元素为1
 *   该list的tail子集合为List(2, 3, 4, 5)
 *   当然也提供了一些最基本的操作，比如isEmpty是否为空List，一个空的List我们使用Nil来进行表示
 */
object _01ListOps {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, 5)
        println("list的首部head元素：" + list.head)
        println("list的尾部子集合tail：" + list.tail)
        println("list是否为空：" + list.isEmpty)
        //练习，使用递归方式进行list集合中元素之和计算
        val sum = getSum(list)
        println("sum: " + sum)
    }
    def getSum(list: List[Int]): Int = {
        if(list.isEmpty) 0
        else
            list.head + getSum(list.tail)
    }
}
