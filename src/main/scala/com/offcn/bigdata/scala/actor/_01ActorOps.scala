package com.offcn.bigdata.scala.actor

import scala.actors.Actor

/*
    学习如何去创建scala的actor--多线程
    创建Actor的步骤：
    1、编写一个类扩展scala.actors.Actor
    2、复写其中的act方法
    3、在act方法内实现偏函数receive，处理外部发生进来的消息
    4、构造一个Actor的对象，调用start方法，启动该线程
    5、通过 ! 发送消息
 */
object _01ActorOps {
    def main(args: Array[String]): Unit = {
        val helloActor = new HelloActor //这就相当于new Thread()
        helloActor.start()
        helloActor ! "柳泽宁"
    }
}

class HelloActor extends Actor { // extends Actor 类似于extends Thread或者implements Runnable
    override def act(): Unit = { // act()相当于实现run()方法
        receive {//接受外部线程发送过来的消息 --偏函数
            case name: String => println("how are you, " + name)
        }
    }
}