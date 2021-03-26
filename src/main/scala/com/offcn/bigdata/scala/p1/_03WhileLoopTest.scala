package com.offcn.bigdata.scala.p1

import scala.io.StdIn


/**
 * while循环练习题
 *   完成用户登陆操作，如果用户输入用户名或者密码不对，给用户最多三次机会。
 *   假设后台数据库中有用户dbUser=zhangsan，dbPwd=sorry
 *   需要从控制台输入用户名和密码进行验证，如果用户名和密码都正确，显示登陆成功，
 *   反之提示重新输入用户名和密码，最多3次机会。
 *
 * 从控制台输入数据：
 *      在java中用Scanner
 *      在scala中，低版本直接readInt,readLine,readChar等等
 *      在高版本中，scala将这些方法封装到了一个工具类StdIn中
 */
object _03WhileLoopTest {
    def main(args: Array[String]): Unit = {

        val dbUser = "zhangsan"
        val dbPwd = "sorry"
        var count = 3
        while(count > 0) {
            val name = StdIn.readLine("请输入您的用户名：")
            val pwd = StdIn.readLine("请输入您的密码：")
            if(name == dbUser && pwd == dbPwd) {
                println("登陆成功，欢迎进入Xxx系统~")
                count = -1
            } else {
                count -= 1
                if(count != 0) {
                    println("用户名或者密码有误，请重试，注意，您还有<" + count + ">次机会。")
                } else {
                    println("账号被锁定，请10分钟之后再试~")
                }
            }
        }
    }
}
