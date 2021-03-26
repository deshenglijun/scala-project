package com.offcn.bigdata.scala.p2.collection

/**
 * scala不可变数组Array的操作
 *      因为不可变，所以只能在创建数组的时候进行初始化
 */
object _01ArrayOps {
    def main(args: Array[String]): Unit = {
        //数组的创建和初始化
        var array = new Array[Int](3)//创建了一个长度为3的Int类型的数组,其初始值为0,0,0
        for(i <- array) {
            println(i)
        }
        println("---------------")
        var strArr = new Array[String](3)//创建了一个长度为3的String类型的数组,其初始值为null,null,null
        for(i <- strArr) {
            println(i)
        }
        println("-------更为常见的数组创建的方式--------")
        array = Array[Int](3)//使用是class Array的[伴生对象]完成数组的创建，创建了一个Int类型，初始化值为3的一个数组
        for(i <- array) {
            println(i)
        }
        println("---------------")
        strArr = Array("hadoop", "spark", "flink")
        for(i <- strArr) {
            println(i)
        }
        println("------------数组Array的crud操作--------------")

        println("获取数组元素：因为[]被用来表示类型或者泛型，所以引用索引得需要使用()")
        println("strArr(1): " + strArr(1))//获取
        strArr(1) = "sparkcore" //修改
        println("strArr(1): " + strArr(1))

        //数组的长度
        println("strArr's length: " + strArr.length + " = " + strArr.size)

        //删除 因为数组不可变，所以不不能删除数组内部元素的，但是我们可以基于不可变的数据进行特有的删除操作
        // 删除指定元素，返回一个新的数组，原数组不变

        var newArray = strArr.drop(1) //从左侧删除N个元素，返回一个新的数组，原数组没有改变
        println("newArray: " + newArray.mkString(","))
        newArray = strArr.dropRight(1) //从右侧删除N个元素，返回一个新的数组，原数组没有改变
        println("newArray: " + newArray.mkString("[", ",", "]"))
        println("原来的数组strArray：" + strArr.mkString("[", ", ", "]"))
    }
}
