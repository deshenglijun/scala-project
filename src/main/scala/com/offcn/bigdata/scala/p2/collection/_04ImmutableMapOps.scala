package com.offcn.bigdata.scala.p2.collection

/**
 * scala不可变map操作
 */
object _04ImmutableMapOps {
    def main(args: Array[String]): Unit = {
        //name--->age
        val pMap = Map[String, Int](
            "佟凯" -> 19,//key指向了value
            ("李梦", 23),
            "陈延年" -> 29,
            ("王珂阳" -> 33)
        )
        println(pMap)

        //如果可以增加元素，其写法为如下：
//        pMap("old李") = 35
        /*
            查询
                方式一：map.get(key)
                    这种方式返回的结果是一个Option[V]，有两个子类：Some和None
                        Some：代表存在value
                        None：代表key在map中不存在
                    如果存在，也就是Some，那么像获取对应的value，得需要使用option/some.get
                    需要说明一点的是，None直接调用get会报错：NoSuchElementException: None.get
         */
        var ageOption:Option[Int] = pMap.get("李梦")
        println(ageOption + "-->age: " + ageOption.get)
        ageOption = pMap.get("郑朝毅")
        println(ageOption + "-->age: "/* + ageOption.get*/)
        //一种更常用的操作 getOrElse(K, default),如果key存在，返回value，key不存在返回对应的默认值default
        val age = pMap.getOrElse("王珂阳", -1)
        println("age: " + age)
        println("----通过map(key)来获取value---=--")

        var tkAge = pMap("佟凯")
        println("pMap(\"佟凯\"): " + tkAge)
        val key = "佟凯2"
        if(pMap.contains(key)) {
            tkAge = pMap(key) //NoSuchElementException: key not found: 佟凯2
            println("pMap(\"佟凯2\"): " + tkAge)
        }
    }
}
