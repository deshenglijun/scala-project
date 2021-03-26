package com.offcn.bigdata.scala.akka.third

import akka.actor.{Actor, ActorLogging, ActorRef}
import com.offcn.bigdata.scala.akka.Protocol.{Request, Response, Sign}

class StudentRemoteActor extends Actor with ActorLogging {

    //从这里需要想办法来找到老师的代理对象
    //path的路径格式: akka.tcp://[actorSystem]@<ip>:<port>/user/actorName
    val path = "akka.tcp://teacherActorSystem@10.10.129.92:2552/user/teacherActor"
    val teacherActorRef = context.actorSelection(path)
    override def receive: Receive = {
        case Sign => {
            teacherActorRef ! Request("树叶为什么是绿色的？")
        }
        case Response(resp) => {
            log.info("老师说： " + resp)
        }
    }
}
