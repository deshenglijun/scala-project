package com.offcn.bigdata.scala.p2.clazz

/**
 * 面向对象的基础内容
 *   类，就是种类，是事物，或者说，就是对某一种事物的抽象的反映，在编程语言中的描述就是通过class来进行体现。
 *   这也是面向对象编程的基础。
 *
 *   和java一样，在scala中也是用关键字class来描述这一类的事物——类。
 *
 *   具备最基本的信息：公共的属性和行为。
 *      把这些属性称之为成员变量，行为称之为成员方法。
 *
 */
object _01ClassOps {
    def main(args: Array[String]): Unit = {
        val person: Person = new Person()
//        person.age = 15
        person.setAge(15)
        person.sleep()
    }
}

class Person {
    /*
        这些成员变量需要提供私有修饰的主要原因，在于保障变量的安全，以及完成更加复杂的初始化工作
        另外的，scala中的访问权限修饰符：只有三种：默认，private，protected，默认可以理解为java中public

     */
    private var name: String = "孤独的牧羊人"
    private var age: Int = 120
    val gender: String = "male"

    def sleep(): Unit = {
        println(s"名为${name}， 年龄为${age}的哥们儿正在呼呼大睡~")
    }

    def setName(name: String): Unit = {
        this.name = name
    }

    def getName(): String = {
        this.name
    }

    def setAge(age: Int) = {
        if(age < 0 || age > 150) {
            throw new RuntimeException("成仙儿还~")
        }
        this.age = age
    }

    def getAge = this.age


}
