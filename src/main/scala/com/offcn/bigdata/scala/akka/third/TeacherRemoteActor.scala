package com.offcn.bigdata.scala.akka.third

import akka.actor.{Actor, ActorLogging}
import com.offcn.bigdata.scala.akka.Protocol.{Request, Response}

class TeacherRemoteActor extends Actor with ActorLogging{
    override def receive: Receive = {
        case Request(req) => {
            log.info("学生的问题是: " + req)
            //向学生做出相应
            log.info("老师思考中.....")
            Thread.sleep(2000)
            log.info("思考结束.")
            sender ! Response("因为树叶里面含有大量叶绿素。")
        }
    }
}