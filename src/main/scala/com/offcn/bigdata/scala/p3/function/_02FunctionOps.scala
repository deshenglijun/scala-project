package com.offcn.bigdata.scala.p3.function

/**
 * scala函数式编程之常见的高阶函数
 * 以下函数都是某一个集合的函数
 * map
 * flatMap
 * filter
 * dropWhile
 * foreach
 * reduce
 * fold
 * groupBy
 * partition
 * sortWith
 */
object _02FunctionOps {
    def main(args: Array[String]): Unit = {
//        mapOps
//        flatMapOps
//        filterOps
//        dropWhileOps
//        foreachOps
//        reduceOps
//        foldOps
//        groupByOps
//        partitionOps
        sortWithOps
    }
    /*
        排序：
            sorted:对集合中的元素进行升序的排序，前提条件是集合的元素要能够进行可比较
            sortBy
            sortWith(p: (A, A) => Boolean)
                对集合中的元素进行两两比较，返回值为true的放在前面，false的放到后面
     */
    def sortWithOps: Unit = {
        var array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))
//        array = array.sorted
        array = array.sortWith((v1, v2) => v1 < v2)
        array = array.sortWith(_ > _)
        array.sorted
        println("排序后的数组：" + array.mkString("[", ", ", "]"))
    }
    /*
        partition(p: A => Boolean):(集合1， 集合2)
        分区函数，只能将原集合按照条件分成了2个区(拆分成两个子集合)，返回值为true的所有的元素构成了集合1，返回值为false
        的元素构成的集合2
     */
    def partitionOps: Unit ={
        val array = 1 to 10
        val (even, odd) = array.partition(num => num % 2 == 0)
        println(s"偶数：${even.mkString("[", ", ", "]")}")
        println(s"奇数：${odd.mkString("[", ", ", "]")}")
    }

    /**
     * 分组：
     * groupBy(p: A => Key): Map[Key, 集合[A]]
     *     对集合中的每一个元素作用groupBy函数，找到要进行分组的key，进行分组
     *
     */
    def groupByOps: Unit = {
        //对数组array中的每一个单词进行负责
        val array = Array(
            "hello you",
            "hello me",
            "hello you"
        )
        val words: Array[String] = array.flatMap(_.split("\\s+"))

        val kvs:Map[String, Array[String]] = words.groupBy(word => word)

        kvs.foreach(kv => {
            println(s"key: ${kv._1}, value: ${kv._2.mkString("[", ", ", "]")}")
            println(s"key: ${kv._1}, value: ${kv._2.length}")
        })
        println("------------------scala wordcount--------------")
        array.flatMap(_.split("\\s+")).groupBy(word => word).foreach(kv => {
            println(s"key: ${kv._1}, count: ${kv._2.length}")
        })
    }

    /**
     * fold(zeroValue)((A1, A2) => A3)
     *     在进行聚合的时候，使用seroValue对A1进行初始化，而不像reduce在第一次调用或者初始化的时候用集合中的前两个元素进行，
     *  同时会比reduce多执行一次计算。
     * fold和reduce的区别：
     * 1 to 5的操作：
     * reduce的实际过程：
     * var sum = 1
     * for(i <- 2 to 5) {
     *   sum = sum + i
     * }
     * fold的实际过程：
     * var sum = zeroValue
     * for(i <- 1 to 5) {
     *   sum = sum + i
     * }
     *
     */
    def foldOps: Unit ={
        val array = 1 to 5
        val sum = array.fold(0)((v1, v2) => {
            println(s"v1: $v1, v2: $v2")
            v1 + v2
        })
        println("fold sum: " + sum)
    }

    /**
     * reduce(p: (A, A) => A)
     * 为了区分改为如下：
     * reduce(p: (A1, A2) => A3)
     * reduce是一个聚合函数——UDAF，将A1和A2作用，进行聚合，得到的结果为A3，A3又成为下一次进行聚合时候的A1
     * 需要特别说明的是，第一次聚合时的A1, A2就是集合中的前两个元素
     * 1 to 5求和
     * var sum = 0
     * for(i <- sum) {
     *   sum = sum + i
     * }
     *
     */
    def reduceOps: Unit = {
        val array = 1 to 5

        var sum = array.reduce((v1, v2) => {
            println(s"v1: $v1, v2: $v2")
            v1 + v2
        })

        sum = array.reduce(_+_)

        println("sum: " + sum)
    }
    /*
        foreach就是对集合的遍历
        foreach(p: A => Unit)

     */
    def foreachOps: Unit = {
        val array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        val result = array.dropWhile((num: Int) => num < 4)
        //遍历输出结果
        result.foreach((num: Int) => print(num + "\t"))
        println
        result.foreach((num) => print(num + "\t"))
        println("--------------")
        result.foreach(println(_))
        println("--------------")
        result.foreach(println)
    }

    /**
     * drop dropRight dropWhile
     * dropWhile(p: A => Boolean)
     * 对集合中的每一个元素A,调用该dropWhile函数，进行删除，直到条件不满足为止，结束删除动作
     */
    def dropWhileOps: Unit = {
        val array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        val result = array.dropWhile((num: Int) => num < 4)
        println(s"dropWhile: ${result.mkString("[", ", ", "]")}")
    }

    /*
        filter(p: (A) => Boolean)
            对原集合中的每一个元素A作用filter函数，删除返回值为false的元素，保留返回值为true组成一个新的集合。
     */
    def filterOps: Unit = {
        val array = 1 to 10
        //过滤奇数，保留偶数
        var result = array.filter((num: Int) => num % 2 == 0)
        println(s"array: ${result.mkString("[", ", ", "]")}")
        result = array.filter(_ % 2 != 0)
        println(s"array: ${result.mkString("[", ", ", "]")}")
    }

    /*
        flatMap(p: (A) => 集合[B])
            flatMap和map的唯一区别就在于，map操作前后是一个元素，对应一个元素，one-2-one
            flatMap，则是作用在原集合中的每一个元素A之上，将每一个元素转化为0到多个新的元素B，one-2-many，对应到sql上的话是：udtf
     */
    def flatMapOps: Unit = {
        //查看如下集合中的单词的个数
        val array = Array(
            "roma was not built in one day",
            "love is blind",
            "god help those who help themselves"
        )
        var result = array.flatMap((line: String) => line.split("\\s+"))
        println(s"array: ${result.mkString("[", ", ", "]")}")
        result = array.flatMap((line) => line.split("\\s+"))
        println(s"array: ${result.mkString("[", ", ", "]")}")
        result = array.flatMap(line => line.split("\\s+"))
        println(s"array: ${result.mkString("[", ", ", "]")}")
        result = array.flatMap(_.split("\\s+"))
        println(s"array: ${result.mkString("[", ", ", "]")}")
    }
    /*
        map(p: (A) => B)
           集合中的元素类型为A, 调用map函数，转化为一个新的集合，新的集合中的元素类型为B.
           map函数的形式参数名称为p，该形式参数的数据类型是一个匿名函数(A) => B, 该匿名函数的参数类型为A，经过转换操作之后将A转化为了类型B，二者之间存在1对1的关系：
           原集合中的一个元素A，作用在map函数之上，转化为了新集合中的一个元素B
           one-2-one -->sql中的udf(一路输入，一路输出)
        eg: 将原集合中的每一个元素扩大2倍
     */
    def mapOps: Unit = {
        var array = Array(1, 2, 3, 4, 5)
        for(i <- 0 until array.length) {
            array(i) = array(i) * 2
        }
        println(s"array: ${array.mkString("[", ", ", "]")}")
        array = array.map((num: Int) => num * 2)
        println(s"array: ${array.mkString("[", ", ", "]")}")
        array = array.map((num) => num * 2)
        println(s"array: ${array.mkString("[", ", ", "]")}")
        array = array.map(num => num * 2)
        println(s"array: ${array.mkString("[", ", ", "]")}")
        array = array.map(_ * 2)
        println(s"array: ${array.mkString("[", ", ", "]")}")
    }
}
