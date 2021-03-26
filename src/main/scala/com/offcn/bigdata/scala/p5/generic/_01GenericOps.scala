package com.offcn.bigdata.scala.p5.generic

import scala.util.control.Breaks.{break, breakable}

/**
 * scala的泛型
 */
object _01GenericOps {
    def main(args: Array[String]): Unit = {
        val iArray = Array(3, -6, 2, 0, 9, 5, 8, 1)
        val fArray = Array[Float](3, -6, 2, 0, 9, 5, 8, 1)
        println("i排序前的数组：" + iArray.mkString("[", ", ", "]"))
        println("f排序前的数组：" + fArray.mkString("[", ", ", "]"))
        val tool = new Tool()
        tool.insertSort(iArray)
        tool.insertSort(fArray)
        println("i排序后的数组：" + iArray.mkString("[", ", ", "]"))
        println("f排序后的数组：" + fArray.mkString("[", ", ", "]"))
    }
}
class Tool {
    def insertSort(array: Array[Int]): Unit = {
        for(i <- 1 until array.length) {
            breakable {
                for (j <- 1 to i reverse) { //reverse集合反转
                    if (array(j) > array(j - 1)) break
                    swap(array, j, j - 1)
                }
            }
        }
    }

    def insertSort(array: Array[Float]): Unit = {
        for(i <- 1 until array.length) {
            breakable {
                for (j <- 1 to i reverse) { //reverse集合反转
                    if (array(j) > array(j - 1)) break
                    swap(array, j, j - 1)
                }
            }
        }
    }

    def swap(array: Array[Int], i: Int, j: Int): Unit = {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
    }
    def swap(array: Array[Float], i: Int, j: Int): Unit = {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
    }
}
