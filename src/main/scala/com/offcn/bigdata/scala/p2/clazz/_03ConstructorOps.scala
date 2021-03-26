package com.offcn.bigdata.scala.p2.clazz

/**
 * scala类的构造器
 *  java中的构造器：
 *      分类为无参构造器(默认的，如果没有手动指定有参构造器的时候，系统会自动提供的构造)，和有参构造器。
 *      其格式为
 *      访问权限修饰符 类名(参数列表) {
 *          构造器的方法体
 *      }
 *  scala中的构造器：
 *      和java中的定义的格式有很大的差异，不能用类名类作为构造器的方法名。
 *      scala中的构造器分为了主构造器和辅助构造器，默认的构造器就是主构造器。
 *          主构造器，就是在类名之后，{括号之前的部分，如果是无参的构造，我们是可以将这个()省略掉的
 *          辅助构造器：就是除了主构造器意外的，用this作为构造器函数名的构造器，语法结构为：
 *          def this(参数列表) {
 *              第一句必须要调用本类的主构造器或者其他的辅助构造器，通过this ===》scala辅助构造器的初始化最终会从主构造器开始进行初始化
 *              方法体
 *          }
 *         所以一个scala的class，只能有一个主构造器和若干个辅助构造器
 */
object _03ConstructorOps {
    def main(args: Array[String]): Unit = {
        val teacher = new Teacher("old李", 36)
        teacher.teach()
        teacher.Teacher()
        println("--------------------------")
        val t1 = new Teacher()
        t1.teach()

    }
}
class Teacher(name: String, age: Int) {
    println("这如果不是构造器的话，那么证明我们的推断是错误的，咱就把它吃了~") // 1
//    var name = "old李"
//    var age = 35
    def this() {//这是scala中的一个无参辅助构造器
        this("zhangsan", 13)
        println("这是scala中的辅助构造器---------") //2
    }
    def Teacher(): Unit = {
        println("如果这是构造器，咱就把他吃了~~~") //3
    }

    def teach(): Unit = {
        println(s"名为${name}, 年龄为${age}的哥们毁人不倦") //4
    }
}
