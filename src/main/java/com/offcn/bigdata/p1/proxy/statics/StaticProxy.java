package com.offcn.bigdata.p1.proxy.statics;

import com.offcn.bigdata.p1.proxy.Singer;

/**
 * java中的代理设计模式：
 *   静态代理
 *   动态代理：
 *      jdk的动态代理（基于父类接口）
 *      cglib动态里(基于子类)
 */
public class StaticProxy {
    public static void main(String[] args) {
        Singer singer = new Singer("蔡徐坤");
        SingerAgent sa = new SingerAgent(singer);
        sa.sing();
    }
}
