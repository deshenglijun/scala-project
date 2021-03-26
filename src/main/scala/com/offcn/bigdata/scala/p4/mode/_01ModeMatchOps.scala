package com.offcn.bigdata.scala.p4.mode

import scala.io.StdIn

/**
 * Scala的模式匹配
 *   语法结构：
 *      变量 match {
 *          case xxxx => yyy
 *          ...
 *          case _ => default process
 *      }
 */
object _01ModeMatchOps {
    def main(args: Array[String]): Unit = {
//        switchOps
//        yeildOps
//        caseOps
        matchCollectionOps(args)
    }
    //匹配数组
    def matchCollectionOps(args: Array[String]): Unit = {
        val array = Array(0, 1)
        array match  {
           //匹配数组array的第一个元素是0
            case Array(0, _ *) => println("数组array的第一个元素为0")
            //匹配如果array中又2个元素，那么久把这两个元素分别赋值给x和y
            case Array(x, y) => println(s"x: ${x}, y: ${y}")
            case _ => println(array.mkString(","))
        }
        println("--------------获取主函数中的程序参数-------------------")
//        val host = args(0)
//        val port = args(1).toInt
//        val time = args(2).toLong
        val Array(host, port, time) = args
        println("host: " + host)
        println("port: " + port)
        println("time: " + time)

        val (sx, wzj, dc, yyh) = ("西施", "王昭君", "貂蝉", "杨玉环")
    }

    //模式匹配中的变量的引用
    def caseOps: Unit = {
        class Person(name: String, age: Int)
        class Teacher(name: String, age: Int) extends Person(name, age) {
            def teach(): Unit = {
                println(s"姓名为：${name}的老师正在吐沫横飞慷慨激昂授课中！")
            }
        }
        class Student(name: String, age: Int) extends Person(name, age) {
            def study(): Unit = {
                println(s"姓名为:${name}, age: ${age}的学生正在不断点头yes，摇头no中~")
            }
        }
        def doSth(p: Person): Unit = {
            p match {
                case t: Teacher => t.teach()
                case s: Student => s.study()
                case _ => println("类型不匹配")
            }
        }
        doSth(new Teacher("old李", 25))
        doSth(new Student("柳泽宁", 18))
    }
    def yeildOps: Unit = {
        println("请输入一个字符：")
        val ch = StdIn.readChar()
        val sign = ch match {
            case '+' => 1
            case '-' => -1
            case '*' => 2
            case '/' => -2
            case _ => 0
        }
        println("sign: " + sign)
    }

    /**
     *  模式匹配模拟java中的switch case 句法结构
     *  从控制台输入一个字符，进行匹配并完成处理
     */
    def switchOps: Unit = {
        while (true) {
            println("请输入一个字符：")
            val ch = StdIn.readChar()
            var sign = 0
            ch match {
                case '+' => sign = 1
                case '-' => sign = -1
                case '*' => sign = 2
                case '/' => sign = -2
                case _ => {
                    System.exit(0)
                }
            }
            println("sign: " + sign)
        }
    }
}
