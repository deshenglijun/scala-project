package com.offcn.bigdata.scala.p4.collection

import scala.collection.mutable

/**
 * Map练习操作
 */
object _04MapOps {
    def main(args: Array[String]): Unit = {
        //wordcount的传统计算方式
        val list = List(
            "hello you",
            "hello me",
            "hello you"
        )
        val words = list.flatMap(_.split("\\s+"))
        val map = mutable.Map[String, Int]()
        for(word <- words) {
//            val countOption = map.get(word)
//            if(countOption.isDefined) {
//                map.put(word, 1 + countOption.get)
//            } else {
//                map.put(word, 1)
//            }
            map.put(word, 1 + map.getOrElse(word, 0))
        }

        println(map)

        println("--------------对上述的结果按照count进行降序排序----------------")
        val kvs: List[(String, Int)] = map.toList
        val sorted = kvs.sortWith((kv1, kv2) =>  kv1._2 > kv2._2)
        sorted.foreach(kv => {
            println(kv._1 + "-->" + kv._2)
        })
    }
}
