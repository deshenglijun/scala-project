package com.offcn.bigdata.scala.p3.extendz

/**
 * 在java中，被protected修饰的成员，就只能在子类中被访问，限制了成员的访问权限
 * 在scala中的protected的特点，如果有需要，我们可以在任意的包中进行访问，而且还可以规定只能在某一个特定类，或特定包中进行访问
 *
 * 我们看到了被修饰为protected的age字段，只能在子类中被访问，但是通过scala的特定访问权限修饰设置，
 * 在访问修饰符后面使用[]指定要访问的package，比如protected[extendz]——代表了该字段只能在extendz包及其子包下面被访问。
 * 这实际上是更加精准的访问权限控制。
 * 当然除了在[]中写package以外，通常还有一个比较常见的关键——this
 *      在上面的age后面添加了[this]之后，在外面访问或者子类中调用person.age里面报错，而什么都不加的时候只有在代码执行编译的时候才报错。
 *      原因在于，被this修饰的字段的访问特点是，只能在本类或者子类声明的时候被访问，而不能用本类对象或者子类的引用来访问。
 *
 *  另外，除了在protected后面加上指定的访问范围以外，scala还可以在private后面跟上具体的访问访问，其作用了类似于protected在指定的范围内被访问。
 */
object _01ProtectedOps {
    def main(args: Array[String]): Unit = {
        val stu = new Student
        val person = new Person()
        person.name = "清华学姐"
        person.age = 23

        stu.makeFriends(person)
    }
}
class Person {
    var name: String = "刘照路"
    protected[extendz] var age: Int = 18
//    protected[this] var age: Int = 18
    private[extendz] var gender = "guy"

    def show(): Unit = {
        println(s"${name}, age: ${age}, gender: ${gender}")
    }
}

class Student extends Person {
    name = "刘照路2"
    age = 19
    def makeFriends(person: Person): Unit = {
        println(s"姓名为:${this.name}, 年龄为${this.age}的小哥哥和${person.name}, 年龄为:${person.age}的小姐姐成为了红颜知己~")
    }
}