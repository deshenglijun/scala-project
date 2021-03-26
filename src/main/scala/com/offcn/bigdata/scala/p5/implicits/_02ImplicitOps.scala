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
 *
 */
object _02ImplicitOps {
    def main(args: Array[String]): Unit = {
        val file = new File("E:/data/flink/hello.txt")
        val lines = file.read()
        for(line <- lines) {
            println(line)
        }

    }
    implicit def file2RichFile(file: File): RichFile = {
        new RichFile(file)
    }
    class RichFile(file: File) {
        def read(): Iterator[String] = {
            Source.fromFile(file).getLines()
        }
    }
}

//包装或者装饰设计模式
class MyFile(file: File) {
    def read(): Unit = {
        val br = new BufferedReader(new FileReader(file))
        br.readLine()
        br.close()
    }
}