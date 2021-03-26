package com.offcn.bigdata.scala.p2.clazz

object _04InnerClassOps {
    def main(args: Array[String]): Unit = {
        val outer = new Outer()
        val inner = new outer.Inner
        inner.show()
    }
}
class Outer { ooooooo =>  //这就是scala为本类的引用起了一个别名，相当于Outer.this或者this
    private val x = 7
    class Inner { iiiii =>
        private val x = 6;
        def show(): Unit = {
            val x = 5;
            println("x: " + x)
            println("inner x: " + this.x)
            println("outer x: " + Outer.this.x)
        }
    }
}
