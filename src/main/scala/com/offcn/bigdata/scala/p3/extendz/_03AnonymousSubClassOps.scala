package com.offcn.bigdata.scala.p3.extendz

/**
 * 匿名子类：
 *  只被调用一次而创建的类的对象，因为是子类，说白了更多了就是类似于java中对接口的实现。
 */
object _03AnonymousSubClassOps {
    def main(args: Array[String]): Unit = {
        fire(new Manager("黄世仁"))
        println("---------------------------------------")
        val m = new Manager("黄世仁"){
            override def manage(): Unit = {
                super.manage()
                println("还有升级版：克扣工资")
            }
            def haha(): Unit = {
                println("哈哈哈")
            }
        }
        m.haha()

        fire(m)

    }
    def fire(manage: Manager): Unit = {
        manage.manage()
        println("所以要炒了经理的鱿鱼~")
    }
}
class Manager(name: String) {
    def manage(): Unit = {
        println(s"行为为${name}的经理正在对员工吆五喝六~")
    }
}
