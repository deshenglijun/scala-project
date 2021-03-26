package com.offcn.bigdata.scala.p3.extendz

/**
 * scala中的抽象类 抽象方法 抽象字段(这在java中不存在)
 *  一个类中的方法或者字段只有定义，没有实现，那么吧这些方法或者字段称之为抽象的方法和字段，
 *  而又抽象方法或者字段的类，我们称之为抽象类，用abstract关键字来进行修饰
 *
 *  同样，抽象方法和字段的abstract关键字可以省略，而类上面abstract可不能省略。
 *
 *  子类如果复写了父类的抽象的成员，是可以省略掉override关键字的，但是复写非抽象成员该关键字必须要加。
 */
object _04AbstractOps {
    def main(args: Array[String]): Unit = {
        val cat = new Cat()
        cat.sleep()
        println("------------------------------")
        val fish = new Fish()
        fish.sleep()
    }
}

/**
 * 定义一个抽象类
 */
abstract class Animal {
    val leg: Int
    def sleep():Unit
    def dead(): Unit = {
        println("动物固有一死，或清蒸，或红烧，或爆炒，这真的是太难了~")
    }
}
class Cat extends Animal {
    val leg: Int = 4

    def sleep(): Unit = {
        println("喵星人，蜷缩成一团睡觉~")
    }
}
class Horse extends Animal {
    override val leg: Int = 4

    override def sleep(): Unit = {
        println("站着睡觉的还有谁！")
    }
}
class Fish extends Animal {
    override val leg: Int = 0

    override def sleep(): Unit = {
        println("睁着眼睛睡觉，太难了我~")
    }
}