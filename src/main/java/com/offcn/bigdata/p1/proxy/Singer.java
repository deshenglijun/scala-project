package com.offcn.bigdata.p1.proxy;

public class Singer implements SingerInterface{
    private String name;

    public Singer() {
    }

    public Singer(String name) {
        this.name = name;
    }

    public void sing() {
        System.out.println("我是" + name + "，全能型歌手，唱跳rap，篮球都会~");
    }
}
