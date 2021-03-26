package com.offcn.bigdata.scala.p1

/**
 * 几个常用的函数
 *  单行函数
 *      顾名思义，函数的实现就只有一句话，这时候我们是可以省略掉{}，但是=不能省略，返回值类型可以省略
 *  无参函数
 *      顾名思义，参数列表为空，在定义的时候()可以省略掉，在调用的时候()也可以省略掉
 *          如果在函数定义的时候省略掉了(),在调用的时候只能省略，不能新增
 *  递归函数
 *      自己调用自己
 */
object _09FunctionDemo {
    def main(args: Array[String]): Unit = {
        val provinceCode = "110000"
        val date = "20201126"
        val random = 3333
        val idcard: String = getIdCard(provinceCode, date, random)
        println(idcard)
        println("----------------$..$---------------")
        show()
        println("---------------->)..(<---------------")
//        递归
        val ret = factorial(5)
        println("5的阶乘为：" + ret)
    }
    /*
        递归求阶乘
            n！其中n > 0的自然数
            n! = n * (n - 1) *...* 3 * 2 * 1
            同时
            1！ = 1

            5！ = 5 * 4 * 3 * 2 * 1
            ==
            5！ = 5 * 4！
            ==》
            n! = n * (n-1)!
     */
    def factorial(num: Int):Int = {
        /* 非递归方式
        var sum = 1
        for(i <- 1 to num) {
            sum *= i
        }
        sum
        */
        //递归的方式
        if(num == 1) {
            1
        } else {
            num * factorial(num - 1)
        }
    }

    //空参函数
    def show(): Unit = {
        println("this is a no params method.")
    }

    //单行函数
    def getIdCard(pCode: String, date: String, random: Int) = s"${pCode}${date}${random}"
}
