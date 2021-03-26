package com.offcn.bigdata.scala.homework

import scala.util.control.Breaks._

/*
有一个scala数组：Array(3, -6, 2, 0, 9, 5, 8, 1)
1.使用冒泡、选择、插入、希尔排序，对以上数组进行升序排序
2.基于1中排序之后的数组，用递归方式实现二分查找
3.用scala实现斐波拉切数列（递归和非递归）
  斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
  求12阶的斐波拉切数列的值
4.求Array(3, -6, 2, 0, 9, 5, 8, 1)数组中的最大值和次大值
 */
object HomeWorkTest1 {

    def main(args: Array[String]): Unit = {
        var array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        println("排序前的数组：" + array.mkString("[", ", ", "]"))
        insertSort(array)
        println("排序后的数组：" + array.mkString("[", ", ", "]"))
        println("--------------------二分查找--------------------------")
        val key = -7
        var index = binarySearch(array, key)
        println(s"${key}在数组${array.mkString("[", ", ", "]")}中的索引为：${index}")
        index = binarySearch(array, key, 0, array.length - 1)
        println(s"${key}在数组${array.mkString("[", ", ", "]")}中的索引为：${index}")
        println("--------------------二分查找--------------------------")
        val fiboracciVal = fiboracci(12)
        println("12阶的Fiboracci值为：" + fiboracciVal)
        println("--------------------最大值和次大值--------------------------")
        array = Array(3, -6, 2, 0, 9, 5, 8, 1)
        val (max, second) = getMaxAndSecondMax(array)
        println(s"数组：${array.mkString("[", ", ", "]")}中的最大值和次大值分别为:${max}, ${second}")
    }

    //最大值和次大值 上一次的max等于这一次的second
    def getMaxAndSecondMax(array: Array[Int]): (Int, Int) = {
        var max = Int.MinValue
        var second = Int.MinValue
        for(i <- array) {
            if(i > max) {
                second = max
                max = i
            }
            if(i > second && i < max) {
                second = i
            }
        }
        (max, second)
    }

    /*
        定义什么是斐波那契数列
            第三个元素，等于前两个元素之和，一次类推
     */
    def fiboracci(level: Int): Int = {
        val array = new Array[Int](12)

        array(0) = 1
        array(1) = 1
        for(i <- 2 until array.length) {
            array(i) = array(i - 1) + array(i - 2)
        }
        println("波拉切数列: " + array.mkString("[", ", ", "]"))
        array(array.length - 1)
    }

    def binarySearch(array: Array[Int], key: Int, start: Int, end: Int): Int = {
        if(start <= end) {
            val mid = (start + end) / 2
            if(key > array(mid)) {
                return binarySearch(array, key, mid + 1, end)
            } else if (key < array(mid)){
                return binarySearch(array, key, start, mid - 1)
            } else {
                return mid
            }
        }
        return -(start + 1)
    }
    def binarySearch(array: Array[Int], key: Int): Int = {
        var start = 0
        var end = array.length - 1
        while (start <= end) {
            val mid = (start + end) / 2
            if(key > array(mid)) {
                start = mid + 1
            } else if (key < array(mid)){
                end = mid - 1
            } else {
                return mid
            }
        }
        return -(start + 1)
    }
    /**
     *
     *
     */
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

    def swap(array: Array[Int], i: Int, j: Int): Unit = {
        val tmp = array(i)
        array(i) = array(j)
        array(j) = tmp
    }


}
