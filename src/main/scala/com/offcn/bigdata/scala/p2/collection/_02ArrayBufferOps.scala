package com.offcn.bigdata.scala.p2.collection

import scala.collection.mutable.ArrayBuffer

/**
 * scala中的可变数组
 */
object _02ArrayBufferOps {
    def main(args: Array[String]): Unit = {
        //创建可变数组ArrayBuffer
        var ab = new ArrayBuffer[Int]() //创建了一个Int类型的可变数组
        ab = ArrayBuffer[Int](1, 2, 3)//使用可变数组的伴生对象来创建一个可变数组，其初始化值为1,2,3
        println("ab: " + ab)
        //添加 或者新增元素
        ab.append(4)
        println("ab.append(4): " + ab)
        val ab1 = ArrayBuffer(5)
        ab.appendAll(ab1)
        println("ab.appendAll(ab1): " + ab)
        //insert 插入
        //insert(index: Int, elems: A*) 指定的索引位置插入多个元素（elems: A*）
        ab.insert(3, -2, -3)
        println("ab.insert(3, -2, -3): " + ab)
        //获取元素和修改元素和Array的操作一样
        /*
            drop    : 删除数组中指定的元素，返回一个新的数组，原数组不变
            remove  : 删除指定索引位置上的元素，并返回该索引对应的元素本身，原数组发生了变化
         */
        val r = ab.remove(3)//删除指定索引位置上的元素
        println("ab.remove(3): " + r + ", 原来的数组：" + ab)
        ab.remove(1, 2)//从指定的元素位置开始删除count个元素
        println("ab.remove(1, 2): " + r + ", 原来的数组：" + ab)

    }
}
