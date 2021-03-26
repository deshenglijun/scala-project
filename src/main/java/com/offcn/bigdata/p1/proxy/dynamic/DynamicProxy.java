package com.offcn.bigdata.p1.proxy.dynamic;

import com.offcn.bigdata.p1.proxy.Singer;
import com.offcn.bigdata.p1.proxy.SingerInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 被匿名内部类所访问的局部变量，必须要被声明为final！
 *  目的是为了，延长局部变量的声明周期，进而避免被匿名内部类访问到不存在的引用造成内存泄漏。
 *
 *  参考资料：https://www.cnblogs.com/teach/p/10763845.html
 */
public class DynamicProxy {
    public static void main(String[] args) {
        final Singer singer = new Singer("Jay Chou");
        SingerInterface si = (SingerInterface) Proxy.newProxyInstance(
                Singer.class.getClassLoader(),
                Singer.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理对象
                     * @param method 要被代理的方法
                     * @param args 被代理的方法的参数
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("基于动态代理的洽谈各种表演事宜");//obj.method(args)//前置通知
                        Object ret = method.invoke(singer, args);
                        System.out.println("基于动态代理的进行尾款善后工作");//connection.commit();//后置通知
                        return ret;
                    }
                });
        si.sing();

    }
}
