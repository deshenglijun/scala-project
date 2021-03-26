package com.offcn.bigdata.scala.homework

/**
 * 用scala函数式编程来完成快速排序：
 */
object HomeWorkTest3 {


    def main(args: Array[String]): Unit = {
        var array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))
        array = quickSort(array)
        println("排序后的数组：" + array.mkString("[", ", ", "]"))
    }

    /**
     * @param array
     *    用scala函数式编程的话，设置到partition分区函数
     *
     *    array.head是集合array中的第一个元素
     *    array.tail是集合array中除了第一个元素以外其他元素构成的一个子集合
     *
     *  val (smaller, bigger) = array.tail.partition(num => num < array.head)
     *  找到了比基准元素都要小的元素构成的集合smaller，比基准元素都要大的元素构成的集合bigger
     *  smaller + array.head + bigger
     *  左侧的smaller仍然无序，右侧的bigger也是无序，进行递归求解
     *  quickSort(smaller) +  array.head  + quickSort(bigger)
     */
    def quickSort(array: Array[Int]):Array[Int] = {
        if(array.isEmpty) {
            Array[Int]()
        } else {
            val (smaller, bigger) = array.tail.partition(num => num < array.head)
            println(smaller.mkString(",") + ", " + array.head + ", " + bigger.mkString(", "))
            quickSort(smaller).:+(array.head) ++ quickSort(bigger)
        }
    }
}
