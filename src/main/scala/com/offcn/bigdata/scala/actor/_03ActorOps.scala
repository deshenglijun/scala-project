package com.offcn.bigdata.scala.actor

import scala.actors.Actor

//线程间通信，模拟学生向老师问问题，老师做出回答这个过程
object _03ActorOps {
    def main(args: Array[String]): Unit = {
        val teacherActor = new TeacherActor
        val stuActor = new StudentActor("柳泽宁")
        teacherActor.start()
        stuActor.start()

        stuActor ! Sign(teacherActor)
    }
}

class TeacherActor extends Actor {
    override def act(): Unit = {
        while(true) {
            receive {
                case Request(req, stuActor) => {
                    val sActor = stuActor.asInstanceOf[StudentActor]
                    println(s"学生: ${sActor.name}, 发送过来的消息是：" + req)
                    Thread.sleep(2000)//模拟老师思考了2分钟
//                    stuActor ! Response("这样可以延长局部变量的生命周期~")
                    //这里在actor中在内存中保存了一个发送消息的对象——sender，在这里其实代表的就是我们的stuActor
                    sender ! Response("这样可以延长局部变量的生命周期~")
                }
            }
        }
    }
}

class StudentActor extends Actor {
    var name: String = _
    def this(name: String) {
        this()
        this.name = name
    }
    override def act(): Unit = {
        while (true) {
            receive {
                case Sign(techerActor) => {//接收到这个信号之后，向老师是问问题
                    techerActor ! Request("为什么匿名内部类访问局部变量，该局部变量需要被final修饰？", this)
                }
                case Response(resp) => {
                    println("老师说：" + resp)
                }
            }
        }
    }
}
case class Sign(actor: Actor)
case class Request(req: String, actor: Actor)
case class Response(resp: String)