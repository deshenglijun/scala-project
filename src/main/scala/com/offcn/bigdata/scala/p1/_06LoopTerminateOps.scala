package com.offcn.bigdata.scala.p1

import scala.io.StdIn
import scala.util.control.Breaks._

/**
 * 循环的终止：
 *  java中：
 *      1、return
 *      2、break、continue
 *      3、使用一些boolean变量
 *  scala中
 *      1、return
 *      2、使用一些boolean变量
 *      3、scala没有break或者continue这些关键字，scala提供了一个breakable的语法结构来完成对break的模拟
 *              import scala.util.control.Breaks._
 *              breakable{
 *                  在指定的地方调用break方法
 *              }
 */
object _06LoopTerminateOps {
    def main(args: Array[String]): Unit = {
        val dbUser = "zhangsan"
        val dbPwd = "sorry"
        var count = 3
        breakable {
            while (count > 0) {
                val name = StdIn.readLine("请输入您的用户名：")
                val pwd = StdIn.readLine("请输入您的密码：")
                if (name == dbUser && pwd == dbPwd) {
                    println("登陆成功，欢迎进入Xxx系统~")
                    break
                } else {
                    count -= 1
                    if (count != 0) {
                        println("用户名或者密码有误，请重试，注意，您还有<" + count + ">次机会。")
                    } else {
                        println("账号被锁定，请10分钟之后再试~")
                        break
                    }
                }
            }
        }
    }

    def method2Return(): Unit = {
        val dbUser = "zhangsan"
        val dbPwd = "sorry"
        var count = 3
        while(count > 0) {
            val name = StdIn.readLine("请输入您的用户名：")
            val pwd = StdIn.readLine("请输入您的密码：")
            if(name == dbUser && pwd == dbPwd) {
                println("登陆成功，欢迎进入Xxx系统~")
                return
            } else {
                count -= 1
                if(count != 0) {
                    println("用户名或者密码有误，请重试，注意，您还有<" + count + ">次机会。")
                } else {
                    println("账号被锁定，请10分钟之后再试~")
                    return
                }
            }
        }
    }
}
