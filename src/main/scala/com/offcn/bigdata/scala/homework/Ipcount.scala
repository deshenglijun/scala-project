package com.offcn.bigdata.scala.homework

object Ipcount {
	def main(args: Array[String]): Unit = {
		   /*
		  传入两个字符串，然后按照"."切割
		  然后进行判断，遍历
		  startIp		endIp
			1.0.1.0	    1.0.3.255	    768
			1.0.8.0	    1.0.15.255	    2048
			1.0.32.0	1.0.63.255	    8192
			1.1.0.0	    1.1.0.255	    256
			根据起始ip和终止ip，来列出所有存在的ip


		    */
		 count("1.0.32.0","1.0.63.255")
	}
      def count(startIp:String,endIp:String):Unit={
	      //定义一个计数器
	      var count = 0
	      var a = 0
	      //开始IP的切割
	      var  start = startIp.split("\\.")
	      var  s1 = Integer.parseInt(start(0))
	      var  s2 = Integer.parseInt(start(1))
	      var  s3 = Integer.parseInt(start(2))
	      var  s4 = Integer.parseInt(start(3))
	      println(">>>>>>>>>>>" +s3)
	      //中止IP的切割
	      var  end = endIp.split("\\.")
	      var  e1 = Integer.parseInt(end(0))
	      var  e2 = Integer.parseInt(end(1))
	      var  e3 = Integer.parseInt(end(2))
	      var  e4 = Integer.parseInt(end(3))
	     println("____________"+e3)
	      count = (e4-s4)+1 + (e3-s3)*256 + (e2-s2)*256*256 +(e1-s1)*256*256*256
	      println(count)
      }

}
