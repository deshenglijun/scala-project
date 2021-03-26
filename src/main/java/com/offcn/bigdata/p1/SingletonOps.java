package com.offcn.bigdata.p1;

/**
 * 所谓单例：就是某一个class只能创建一个对象
 */
public class SingletonOps {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println("-----------------Lazy------------------");
        LazySingleton ls1 = LazySingleton.getInstance();
        LazySingleton ls2 = LazySingleton.getInstance();
        System.out.println(ls1 == ls2);

    }
}
/**
 * 饿汉式
 * 1、就是要私有化构造函数
 * 2、提供一个public的 static的方法来获取该对象
 * 3、需要内部构造一个private static的本类引用供2中的方法来返回
 */
class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
/**
 * 懒汉式
 * double check
 */
class LazySingleton {
    private static LazySingleton instance = null;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized(LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

