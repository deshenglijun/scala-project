package com.offcn.bigdata.scala.p5.generic

/**
 * scala泛型的特点
 *  默认情况下：=左右两侧的泛型仍然和java一样，必须要保持一致。
 *  但是，scala语法结构灵活，考虑到前面说出现的情况
 *      scala是可以允许出现=左右两侧的泛型之间的继承关系：
 *      只需要将定义泛型的时候，加上+或者-即可，比如
 *      [+T]：这种称之为发行的协变，允许等号右侧的泛型继承等号左侧的泛型
 *      [-T]：这种称之为发行的逆变，允许等号左侧的泛型继承等号右侧的泛型
 */
object _04GenericOps {
    def main(args: Array[String]): Unit = {
        val list:MyList[Person] = new MyList[Student]()

        val list2:MyList2[Student] = new MyList2[Person]()

    }
    class MyList[+T] { //这就是scala中泛型的协变
    }

    class MyList2[-T] {//这就是scala中泛型的逆变
    }
    class Person{}
    class Student extends Person{}
    class Teacher extends Person{}
}
