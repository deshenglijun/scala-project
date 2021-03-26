package com.offcn.bigdata.scala.p2.collection

/**
 * Tuple 元组，一组值的列表，这一组值的数据类型可以相同，也可以不同
 * 可以简单理解为java中的List<Object>，或者scala中的Array[Object]
 * 因为是不可变的集合，所以在创建的时候就要完成初始化赋值
 */
object _06TupleOps {
    def main(args: Array[String]): Unit = {
        //构建 tuple
        val t = new Tuple2[String, Int]("范雅骞", 16)
        val tt = ("刘国伟", 33)

        //获取tuple中的元素，格式: tuple._index（index从1开始）
        //第一个元素：t._1, 第二个元素：t._2
        val name = t._1
        val age = t._2
        println(s"name: ${name}, age: $age")
        //这种方式的代码阅读性不强
        val season = ("spring", "summer", "autumn", "winter")
        //另一种tuple的定义的方式
        val (spring, summer, autumn, winter) = ("spring", "summer", "autumn", "winter")

        println("spring: " + spring)
        println("summer: " + summer)
        println("autumn: " + autumn)
        println("winter: " + winter)

        //遍历 tuple是不可以直接进行遍历的，因为没有继承Iterable接口，得需要调用productIterator方法产生迭代器
        //主要原因在于tuple继承的是product这样一个类，该类提供的productIterator，同时实现了序列化
        for(s <- season.productIterator) {
            println(s)
        }
    }
}
