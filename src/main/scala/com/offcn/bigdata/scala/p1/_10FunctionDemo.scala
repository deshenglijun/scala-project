package com.offcn.bigdata.scala.p1

/**
 * scala函数参数特点：
 *  默认参数和带名参数
 *      默认参数，指的是在函数定义的时候，就给该参数赋了默认值，所以在调用的时候可以省略掉这个参数
 *  带名参数
 *      在给形参传递实参的时候，可以带上形参的名称来完成赋值
 *  根据用户的省份，姓名，手机号，组合成用户的收货地址
 */
object _10FunctionDemo {
    def main(args: Array[String]): Unit = {
        showAddr("王世伟", "吉林")
        showAddr("张瑞鹏", "内蒙", phone = 17739485674L)
        println("-------------带名参数------")
        showAddr("杨月龙", province = "河北")
        showAddr(phone = 17739485674L, province = "河北", name = "刘炳文")
    }

    /**
     *
     * @param name
     * @param province
     * @param phone 该参数有默认值，为13988881688L
     */
    def showAddr(name: String, province: String, phone: Long = 13988881688L): Unit = {
        println(s"name: ${name}, province: ${province}, phone: ${phone}")
    }
}
