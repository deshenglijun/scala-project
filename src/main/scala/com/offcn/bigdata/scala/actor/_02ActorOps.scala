package com.offcn.bigdata.scala.actor

import java.text.SimpleDateFormat
import java.util.Date

import scala.actors.Actor

//基于case class的方式来传递消息
object _02ActorOps {
    def main(args: Array[String]): Unit = {
        val fuBenActor = new FuBenActor
        fuBenActor.start()
        fuBenActor ! FuBen(1010, "亚瑟", 1000, System.currentTimeMillis(), "圣光裁决")
    }
}
class FuBenActor extends Actor {
    val df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    override def act(): Unit = {
        receive {
            case FuBen(uid, rule, count, time, skill) => {
                val date = new Date(time)
                println(s"uid为${uid}在时间为：${df.format(date)}的时候，使用技能:${skill}，对${rule}角色，发起了${count}了冲锋")
            }
        }
    }
}
case class FuBen(uid: Int, rule: String, count: Int, time: Long, skill: String)
