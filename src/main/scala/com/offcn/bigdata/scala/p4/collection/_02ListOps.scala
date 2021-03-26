package com.offcn.bigdata.scala.p4.collection

//list的crud的操作
object _02ListOps {
    def main(args: Array[String]): Unit = {
        val left = List(1, 2, 3, 4, 5)
        val right = List(6, 7, 8, 9, 10, 11, 12)
        /*
            添加元素
            list.+:(A): 在list的首/头部添加一个元素A，返回一个新的集合，原集合不变
            list.::(A): 在list的首/头部添加一个元素A，返回一个新的集合，原集合不变
            list.:+(A): 在list的尾部添加一个元素A，返回一个新的集合，原集合不变
         */
        var ret = left.+:(6)
        println("left.+:(6): " + ret)
        ret = left.::(6)
        println("left.::(6): " + ret)
        ret = left.:+(6)
        println("left.:+(6): " + ret)
        /*
            添加集合
            left.:::(right): 在list的首/头部添加一个集合right，返回一个新的集合，原集合不变
            list.++:(A): 在list的首/头部添加一个集合right，返回一个新的集合，原集合不变
            left.++(right): 在left的尾部添加一个集合right，返回一个新的集合，原集合不变
         */

        ret = left.++:(right)
        println("left.++:(right): " + ret)

        ret = left.:::(right)
        println("left.:::(right): " + ret)

        ret = left.++(right)
        println("left.++(right): " + ret)

        //删除 drop dropRight dropWhile

        //获取index为2的元素
        val ele = ret(2)
        println("index为2的元素为：" + ele)

        //更新，因为list为不可变集合，所以只能在初始化的时候进行赋值，不可以进行修改
        //others
        //par：将一个集中式的集合，转化为一个并行的一个集合，
        println("ret.par: " + ret.par)
        //slice获取集合的子集合[from, until)
        val result = ret.slice(from = 1, until = 4)
        println("ret.slice(from = 1, until = 4): " + result)
        //对集合中的每一个元素作用span函数，将提交满足的元素放到leftList中，直到条件不满足为止，将其之后的所有元素放到rightList中
        val (leftList, rightList) = ret.span(num => num % 2 != 0)
        println("leftList: " + leftList)
        println("rightList: " + rightList)
    }
}
