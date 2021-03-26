package com.offcn.bigdata.scala.akka.third

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object TeacherServerDriver {
    def main(args: Array[String]): Unit = {
        //加载配置文件中的teacherActor的配置信息，进而启动一个服务端，来监听客户端的连接
        val teacherActorSystem = ActorSystem("teacherActorSystem",
            ConfigFactory.load().getConfig("MyRemoteServerSideActor"))

        teacherActorSystem.actorOf(Props[TeacherRemoteActor], "teacherActor")

        val log = teacherActorSystem.log

        log.info("服务端的老师已经就位。。。开放的ip地址为: 10.10.129.92, port为：2552")
    }
}
