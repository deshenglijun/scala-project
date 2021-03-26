package com.offcn.bigdata.scala.akka

object Protocol {
    case object Sign
    case class Request(req: String)
    case class Response(resp: String)
}
