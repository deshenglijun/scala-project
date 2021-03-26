package com.offcn.bigdata.scala.p2.collection

import scala.collection.mutable

/**
 * scala可变map
 */
object _05MutableMapOps {
    def main(args: Array[String]): Unit = {
        //定义一个可变的map
        val map = mutable.Map[String, Int](
            "佟凯" -> 19,//key指向了value
            ("李梦", 23),
            "陈延年" -> 29,
            ("王珂阳" -> 33)
        )

        println(map)
        //添加元素
        map("old李") = 35
        map("陈延年") = 66
        map += ("庞海浩" -> 22)
        println(map)

        //删除
        val removedOp: Option[Int] = map.remove("old李")
        println(removedOp + ", " + map)

        //遍历
        for(kv <- map) {
            println(s"name: ${kv._1}, age: ${kv._2}")
        }
        println("------------------")
        for((name, age) <- map) {
            println(s"name: ${name}, age: ${age}")
        }



    }
}
