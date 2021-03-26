package com.offcn.bigdata.scala.akka.second

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.offcn.bigdata.scala.akka.Protocol.{Request, Response, Sign}

/**
 * 学生和老师进行双向通信的案例:
 *  需求：
 *      学生做作业遇到问题之后，向老师请教
 *      老师收到问题之后，便向学生做出反馈
 */
object StudentTeacherAKKAActorOps {
    def main(args: Array[String]): Unit = {
        val actorSystem = ActorSystem.create("stu-teacher-system")
        //创建老师的代理
        val teacherActorRef = actorSystem.actorOf(Props[TeacherActor], "teacherActor")
        //创建学生的代理
        val stuActorRef = actorSystem.actorOf(Props(classOf[StudentActor], teacherActorRef), "studentActor")

        //问问题
        stuActorRef ! Sign
    }
}

class TeacherActor extends Actor {
    override def receive: Receive = {
        case Request(req) => {
            println("学生的问题是: " + req)
            //向学生做出相应
            println("老师思考中.....")
            Thread.sleep(2000)
            println("思考结束.")
            sender ! Response("因为树叶里面含有大量叶绿素。")
        }
    }
}

//在akka中actor的行为都是通过其代理对象actorRef来实现的
class StudentActor(teacherActorRef: ActorRef) extends Actor {
    override def receive: Receive = {
        case Sign => {
            teacherActorRef ! Request("树叶为什么是绿色的？")
        }
        case Response(resp) => {
            println("老师说： " + resp)
        }
    }
}

