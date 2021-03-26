package com.offcn.bigdata.scala.p3.function

object _03FunctionOps {
    def main(args: Array[String]): Unit = {
//        closureOps
        curryingOps
    }

    /**
     * 柯里化：原先一个函数又2个参数，经过柯里化之后，这个函数的参数个数变成了1个
     * 但是又要完成之前的功能，所以函数的实现就成了以第二个参数为匿名函数的实现于调用
     * 在函数调用的时候，就可以类似参数连续被调用
     */
    def curryingOps: Unit = {
        def add(a: Int, b: Int) = a + b
        //柯里化
        def sum(a: Int) = (b: Int) => a + b
        val aa = sum(3)
        val tt = aa(5)
        println(tt)
        val ret = sum(3)(5)
        println("ret: " + ret)
    }

    def closureOps: Unit = {
        def mulBy(factor:Double) = (x:Double) => factor * x

        var triple = mulBy(3)
        val half = mulBy(0.5)

        println(triple(14) + "--->" + half(14))
    }
}
