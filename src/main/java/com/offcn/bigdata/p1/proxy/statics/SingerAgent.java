package com.offcn.bigdata.p1.proxy.statics;

import com.offcn.bigdata.p1.proxy.Singer;

public class SingerAgent {
    private Singer singer;

    public SingerAgent(Singer singer) {
        this.singer = singer;
    }

    public void sing() {
        System.out.println("洽谈各种表演事宜");//connection.setAutoCommit(false);
        singer.sing();
        System.out.println("进行尾款善后工作");//connection.commit();
    }
}
