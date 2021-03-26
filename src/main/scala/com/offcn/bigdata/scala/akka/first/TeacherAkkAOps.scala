package com.offcn.bigdata.scala.akka.first

import akka.actor.{Actor, ActorSystem, Props}
import com.offcn.bigdata.scala.akka.Protocol.Request

object TeacherAkkAOps {
    def main(args: Array[String]): Unit = {
        //step 1. create actor system
        val actorSystem = ActorSystem.create("stu-teacher-system")
        //step 2. 从actorSystem中获取发送消息的对象(代理对象)---actorSystem.actorOf
        val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])
        // step 3. send msg to actor
        teacherActorRef ! Request("树叶为什么是绿色的？")
        teacherActorRef ! Request("天空为什么是蓝色？")

    }
}

class TeacherActor extends Actor {
    override def receive: Receive = {
        case Request(req) => {
            println("学生的问题是:" + req)
        }
    }
}
