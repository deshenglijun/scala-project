package com.offcn.bigdata.scala.p2.collection

/**
 * zip： 拉链
 *  将两个单列的集合组合成一个双列的集合
 *  集合中多余的部分，将会被裁减掉
 * zipAll(that, thisEle, thatEle)
 *  就是在zip的基础之上，对多余不对齐的元素使用thisEle和thatEle（默认值）进行对其
 *
 * unzip: 就是zip的逆过程
 */
object _07ZipOps {
    def main(args: Array[String]): Unit = {
        val provinces = Array("吉林", "河北", "山东", "内蒙", "福建")

        val capitals = Array("长春", "石家庄", "济南", "呼和浩特", "福州", "南昌")

        var pcs: Array[(String, String)] = provinces.zip(capitals)
        for(pc <- pcs) {
            println(pc)
        }
        println("-----zipAll----")
        pcs = provinces.zipAll(capitals, "江西", "长沙")
        for(pc <- pcs) {
            println(pc)
        }
        //zip
        val (pc, cs) = pcs.unzip
        println("pc: " + pc.mkString("[", ", ", "]"))
        println("cs: " + cs.mkString("[", ", ", "]"))
    }
}
