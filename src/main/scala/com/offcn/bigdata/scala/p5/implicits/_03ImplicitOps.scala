package com.offcn.bigdata.scala.p5.implicits

import java.io.{BufferedReader, File, FileReader}

import com.offcn.bigdata.scala.p4.collection.Person

import scala.io.Source

/**
 * 隐式转换
 *    是scala中一个非常强大的功能，会根据需要将以中类型自动的转化为其他的类型，从而让原有的类型具备了被转化类型的api，
 *    说白了也就是丰富了现有api。
 *    而这背后都是通过一个叫做隐式转换函数的东东来实现。
 *
 *    隐式转换函数的语法格式
 *
 *    implicit def source2Target(source: Source): Target = {
 *    }
 *    这里需要涉及到一个隐式转换关键字：implicit
 *
 *    其非常重要的一个作用：就是丰富现有api操作
 *
 * 隐式转换的引入：
 *    隐式转换的导入和导包是非常相似的，只需要在使用的地方完成导入即可
 *
 */
//import _02ImplicitOps.file2RichFile
//import _02ImplicitOps._
object _03ImplicitOps {
    def main(args: Array[String]): Unit = {
        val file = new File("E:/data/flink/hello.txt")
        import _02ImplicitOps._
        val lines = file.read()
        for(line <- lines) {
            println(line)
        }
    }
}

