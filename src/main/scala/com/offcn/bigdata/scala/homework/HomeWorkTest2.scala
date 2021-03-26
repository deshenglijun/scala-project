package com.offcn.bigdata.scala.homework

/**
 * 字符串: "  adsd fff   "
 *
 *  编写一个函数，去除前后两端的空格，类似于String的trim
 */
object HomeWorkTest2 {
    def main(args: Array[String]): Unit = {
        val str = "  adsd fff   "
        var result = myTrim(str)
        result = myTrim2(str)
        println(s"|${result}|")
    }
    /*
        函数式编程的思维
        直到遇到非空格就不删除了
     */
    def myTrim2(str: String): String = {
        str.dropWhile(ch => ch == ' ').reverse.dropWhile(_ == ' ').reverse
    }
    /**
     *
     * @param str
     * @return
     */
    def myTrim(str: String): String = {
        var start = 0
        var end = str.length - 1
        while((start <= end) && str.charAt(start) == ' ') {
            start += 1
        }
        while((start <= end) && str.charAt(end) == ' ') {
            end -= 1
        }
        str.substring(start, end + 1)
    }
}
