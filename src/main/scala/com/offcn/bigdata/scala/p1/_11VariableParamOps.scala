package com.offcn.bigdata.scala.p1

/**
 * scala版本的可变参数
 * scala的可变参数，经过虚拟机处理之后转变为了(Seq<Object> arr)，不想java的可变参数直接转变为了数组
 * 所以对于scala中的可变参数，不能直接传递数组元素，如果想要给可变参数传递一个数组的时候，需要在数组后边跟上: _*
 */
object _11VariableParamOps {
    def main(args: Array[String]): Unit = {
        println(add(1, 2, 3))
        println(add(Array(1, 2, 3, 4): _*))
    }

    def add(a: Int, b: Int) = {
        a + b
    }

//    def add(arr: Array[Int]): Int = {
//        var sum = 0
//        for(i <- arr) {
//            sum += i
//        }
//        sum
//    }

    def add(arr: Int*): Int = {
        var sum = 0
        for(i <- arr) {
            sum += i
        }
        sum
    }


}
