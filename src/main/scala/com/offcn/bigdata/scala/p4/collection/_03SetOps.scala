package com.offcn.bigdata.scala.p4.collection

import scala.collection.immutable.{HashSet, SortedSet}

/**
 * set集合操作:
 *  和数学中的set集合一样，具有三个特点:有穷性，唯一性，无序性
 *  构建有序的集合就需要使用SortedSet或者TreeSet
 */
object _03SetOps {
    def main(args: Array[String]): Unit = {
        val set = Set(1, 2, 3, 4, 5, 6, 8) + 3
        println(set)
        val hs = HashSet(1, 2, 3, 4, 5, 6, 8)

        println(hs)
        //有序的集合
        println("---------------------------------------")
        val sortedSet = SortedSet("abc", "abb", "abcd", "a", "heihei")
        println("sortedSet" + sortedSet)
        /*
            在java中的对象的比较通过comparable和comparator
                对象的可比较性通过comparable来实现
                容器的比较器通过comparator来实现
            在scala中的对象的比较通过Ordered和Ordering来实现
                对象的可比较性通过Ordered来实现
                容器的比较器通过Ordering来实现
            scala的和java中的关系:
                Ordered extends Comparable
                Ordering extends Comparator with Serializable
         */
        val ps = SortedSet(
            new Person("fan雅骞", 14),
            new Person("sun文文", 17),
            new Person("tian军洋", 15),
            new Person("wei超", 18),
            new Person("old李", 38)
        )(new Ordering[Person](){
            //姓名升序，年龄降序
            override def compare(x: Person, y: Person): Int = {
                var ret = x.name.compareTo(y.name)
                if(ret == 0) {
                    ret = y.age.compareTo(x.age)
                }
                ret
            }
        })

        println("persons: " + ps)
    }
}
class Person extends Ordered[Person] {
    var name: String = _
    var age: Int = 0
    def this(name: String, age: Int) {
        this()
        this.name = name
        this.age = age
    }

    override def toString: String = this.name + "---->" + this.age

    /*
        年龄的降序排序，姓名的升序
        公式:
            升序：前面的比后面的
            降序：后面的比前面的
     */
    override def compare(that: Person): Int = {
        var ret = that.age.compareTo(this.age)
        if(ret == 0) {
            ret = this.name.compareTo(that.name)
        }
        ret
    }
}
