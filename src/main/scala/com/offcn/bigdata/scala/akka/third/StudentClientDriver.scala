package com.offcn.bigdata.scala.akka.third

import akka.actor.{ActorSystem, Props}
import com.offcn.bigdata.scala.akka.Protocol.Sign
import com.typesafe.config.ConfigFactory

object StudentClientDriver {
    def main(args: Array[String]): Unit = {
        val stuActorSystem = ActorSystem("stuActorSystem",
            ConfigFactory.load().getConfig("MyRemoteClientSideActor"))

        val log = stuActorSystem.log
        val stuActorRef = stuActorSystem.actorOf(Props[StudentRemoteActor], "stuActor")
        log.info("学生上线了，准备问问题~")

        stuActorRef ! Sign

    }
}
