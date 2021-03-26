package com.offcn.bigdata.scala.p5.implicits
/*
    隐式转换参数：
        一个函数参数被implicit修饰，我们称这个参数为隐式转换参数。
    特点：
        1. 通常情况下，一个参数是隐式转换参数的话，系统会提供默认的实现，不需要我们人工手动传入参数
        2. 如果我们要手动的完成参数的传入，怎么办？两种方式
            1°、显示的传入相关参数
            2°、如果没有显式的传入，编译器会自动地在其作用域范围内去检索被implicit修饰的所需要类型的变量，
                如果能够检索到，自动完成赋值
 */
object _04ImplicitOps {
    def main(args: Array[String]): Unit = {
        var array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))

//        implicitParam(array)
        sortByOps()
    }
    def sortByOps(): Unit = {
        val array = Array(
            "hello you",
            "hello me",
            "hello you",
            "shit me"
        )
        val t = ("hello", Array("hello", "hello"))

        //wordcount 其次排序
        val word2Count:Map[String, Int] = array.flatMap(_.split("\\s+")).groupBy(word => word)
//            .map(kv => (kv._1, kv._2.size))//模式匹配
            .map{case (word,  wordArray) => (word, wordArray.length)}
        //排序
        word2Count.toList.sortBy{case (word, count) => count}(new Ordering[Int](){
            override def compare(x: Int, y: Int): Int = y.compareTo(x)
        }).foreach(println)
        println("----------------------------------------")
        //次数优先排序，相等时按照单词的升序排序
        word2Count.toList.sortBy(kv => kv)(new Ordering[(String, Int)](){
            override def compare(x: (String, Int), y: (String, Int)): Int = {
                var ret = y._2.compareTo(x._2)
                if(ret == 0) {
                    ret = x._1.compareTo(y._1)
                }
                ret
            }
        }).foreach(println)

    }
    def implicitParam(array: Array[Int]): Unit = {
        //显示传入隐式转换参数
        var result = array.sorted(new Ordering[Int](){ // 显示的传入隐式转换参数
            override def compare(x: Int, y: Int): Int = y.compareTo(x)
        })

        //隐式的传入
        implicit val ord = new Ordering[Int]() {
            override def compare(x: Int, y: Int): Int = y.compareTo(x)
        }

        result = array.sorted
        println("排序后的数组：" + result.mkString("[", ", ", "]"))
    }
}
