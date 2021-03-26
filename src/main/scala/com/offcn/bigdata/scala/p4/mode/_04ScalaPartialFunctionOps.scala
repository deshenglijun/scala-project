package com.offcn.bigdata.scala.p4.mode

/**
 * scala偏函数
 *   偏函数(PartialFunction)实际上是对于普通函数进行模式匹配的一个简化的写法
 *   def funcName(param): returnType = {
 *      param match {
 *          case xxxx
 *          case xxx
 *      }
 *   }
 *  偏函数的写法：
 *  def funcName: PartialFunction[paramType, returnType] = {
 *      case xxxx
 *      case xxx
 *  }
 */
object _04ScalaPartialFunctionOps {
    def main(args: Array[String]): Unit = {
        acrossRoad(Red("红色"))
        across(Green("绿色"))
    }

    def across: PartialFunction[TrafficLight, Unit] = {
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
}
