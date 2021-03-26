package com.offcn.bigdata.scala.p4.mode

/**
 * scala用case class来模拟枚举
 *  在java中我们可以用enum类似于class的语法结构来定义枚举，但是在scala中没有类似于java中这样的结构来定义枚举。
 *  通常又2中方式来定义枚举：
 *  1.通过Enumeration的工具类来完成枚举定义
 *  2.使用case class来完成枚举的定义
 *
 */
object _03EnumOps {
    def main(args: Array[String]): Unit = {
//        work(Weekday.FRI)
        acrossRoad(Red("红色"))
    }

    def acrossRoad(trafficLight: TrafficLight) {
        trafficLight match {
            case Red(color) => {
                println(s"${color}亮起要停止，否则亲人泪两行~")
            }
            case Yellow(color) => {
                println(s"${color}亮起要hurry up要么久别过了，否则亲人泪两行~")
            }
            case Green(color) => {
                println(s"${color}亮起要抓紧过马路")
            }
        }
    }
    def work(weekday: Weekday.Value): Unit = {
        weekday match {
            case Weekday.MON => {
                println("节后综合征")
            }
            case Weekday.TUE => {
                println("进入上班的状态")
            }
            case Weekday.WED => {
                println("期待周末要到来")
            }
            case Weekday.THU => {
                println("再坚持一下")
            }
            case Weekday.FRI => {
                println("准备进入嗨的状态")
            }
            case Weekday.SAT => {
                println("周六过来加班")
            }
            case Weekday.SUN => {
                println("007走")
            }
        }
    }
}
//scala中枚举基于Enumeration工具类的定义
object Weekday extends Enumeration {
    val MON, TUE, WED, THU, FRI, SAT, SUN = Value
}

/**
 * scala中被sealed修饰的类，称之为密封类，什么特点？
 *  如果一个类被sealed修饰，那么等于告诉编译器，在运行期其所有的子类都是已知，说白了该类的所有的子类都已经定义完成
 */
sealed class TrafficLight(color: String)
case class Red(color: String) extends TrafficLight(color)
case class Yellow(color: String) extends TrafficLight(color)
case class Green(color: String) extends TrafficLight(color)