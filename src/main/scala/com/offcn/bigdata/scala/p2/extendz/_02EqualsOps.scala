package com.offcn.bigdata.scala.p2.extendz

/**
 * scala中的类型检查和类型转换
 */
object _02EqualsOps {
    def main(args: Array[String]): Unit = {
        val w1 = new Worker("孙文文", 18)
        val w2 = new Worker("孙文文", 18)
        println(w1.equals(w2))
    }
}
class Worker {
    var name: String = _
    var age: Int = _
    def this(name: String, age: Int) {
        this()
        this.name = name
        this.age = age
    }
    /*
    override def equals(obj: Any): Boolean = {
        if(obj == null) {
            false
        } else {
            //scala中的类型检查
            if(!obj.isInstanceOf[Worker]) {
                false
            } else {
                //类型转换 相当于java中的强制类型转化
                val that = obj.asInstanceOf[Worker]
                this.name.equals(that.name) && this.age == that.age
            }
        }
    }
    */
    override def equals(obj: Any): Boolean = {
        obj match {//使用模式匹配的方式来完成类型的检查和类型的转换
            case that: Worker => this.name.equals(that.name) && this.age == that.age
            case _ => false
        }
    }
}
