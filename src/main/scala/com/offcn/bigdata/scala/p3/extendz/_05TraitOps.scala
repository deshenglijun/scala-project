package com.offcn.bigdata.scala.p3.extendz

import java.io.FileWriter

/**
 * trait特质：
 *  不管是java还是scala的继承，有一个特点：只能单继承，不能多继承，在java中来弥补这个缺陷怎么解决：
 *      1、可以多层继承
 *      2、进行多实现(implements interface)
 *  在多实现这个接口的时候，比较痛苦，如果接口方法比较少还好，但是如果方法很多，实现起来非常的麻烦
 *  所以scala有了trait这样一个概念来弥补java中的interface只能由抽象方法的缺陷
 *
 *  所以scala中的trait比java中的接口interface内容更加的丰富，既可以拥有抽象，也可以有拥有非抽象，当trait特质中的所有
 *  方法都抽象的时候，我们就可以理解其为java中的接口。
 *
 *  trait在进行调用的时候和scala的类的调用一样，都要使用关键字extends，而java的接口实现用implements
 *  java的实现多接口的时候通过多个,来进行分割。很遗憾scala扩展多个trait的时候使用关键字with来进行分割。
 *
 *  比java中的接口还牛的一点是，可以做到动态的运行时的扩展特质————特质的混入
 *
 *  如果scala的一个类，既要扩展一个类，又要扩展特质，那么先写类，其次用with连接trait特质
 */
object _05TraitOps {
    def main(args: Array[String]): Unit = {
        val logger = new ConsoleLogger
        logger.log("roma was not built in one day~")
        println("--------------------------")
        val fileName = "E:/data/out/scala/fileLogger.txt"
        val fLoger = new FileLogger(fileName) with MySerializable
        fLoger.log("god help those who help themselves.")
        fLoger.log("love is blind.")
        fLoger.close()
        fLoger.serialize("书到用时方恨少，绝知此事要躬行。")
    }
}

trait Logger {
    def log(msg: String): Unit

    def show(): Unit = {
        println("show~")
    }
}

trait MySerializable {
    //完成了序列化
    def serialize(msg: String): Unit = {
        println("serilaize: " + msg)
    }
}

class ConsoleLogger extends Logger {
    override def log(msg: String): Unit = {
        println("consoleLogger: " + msg)
    }
}

class FileLogger(fileName: String) extends Logger /*with MySerializable */{
    private val bw = new FileWriter(fileName, true)
    override def log(msg: String): Unit = {
        bw.write(msg)
        bw.write("\r\n")
        bw.flush()
    }
    def close(): Unit = {
        if(bw != null) {
            bw.close()
        }
    }
}

