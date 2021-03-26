package com.offcn.bigdata.scala.p5.generic

import scala.util.control.Breaks.{break, breakable}

/**
 * scala的泛型方法
 *  方法上面的泛型需要定义在方法名和参数列表之间
 */
object _03GenericOps {
    def main(args: Array[String]): Unit = {
        val iArray = Array[Int](3, -6, 2, 0, 9, 5, 8, 1)
        val fArray = Array[Float](3, -6, 2, 0, 9, 5, 8, 1)
        println("i排序前的数组：" + iArray.mkString("[", ", ", "]"))
        println("f排序前的数组：" + fArray.mkString("[", ", ", "]"))
        val tool = new Tool3()
        tool.insertSort(iArray)
        tool.insertSort(fArray)
        println("i排序后的数组：" + iArray.mkString("[", ", ", "]"))
        println("f排序后的数组：" + fArray.mkString("[", ", ", "]"))
    }
}

/**
 *  java中进行泛型上限限定的格式为： <T extends Xxx>
 *  scala中进行泛型上限限定的格式为：[T <: Xxx]
 *  但是在上述调用过程中发现了编译错误：
 *     type arguments [Int] do not conform to class Tool2's type parameter bounds [T <: Ordered[T]]
 *     val tool = new Tool2[Int]()
 *   通过查看源码，发现Int/Float并没有扩展Ordered或者Comparable，但是作为一个数字确实可以进行比较的，要想完成上述的操作，只需要将
 *   泛型的限定做一下修改————将泛型的上限限定改为视图界定即可：
 *
 *    视图界定的格式为[T <% Xxx]，再一次执行代码，发现可以正常执行成功，why？
 *      这个原因是因为使用试图界定，对Int这个类型进行了功能升级！
 *      这个背后都是一个叫做隐式转换的scala中非常牛逼的特征来实现的！
 */
class Tool3 {
    def insertSort[T <% Ordered[T]](array: Array[T]): Unit = {
        for(i <- 1 until array.length) {
            breakable {
                for (j <- 1 to i reverse) { //reverse集合反转
                    if (array(j) > array(j - 1)) break
                    swap(array, j, j - 1)
                }
            }
        }
    }

    def swap[T](array: Array[T], i: Int, j: Int): Unit = {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
    }
}
