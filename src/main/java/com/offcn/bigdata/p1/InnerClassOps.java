package com.offcn.bigdata.p1;

/**
 *  内部类，就是定义在类的内部的类。
 */
public class InnerClassOps {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer {
    private int x = 5;
    class Inner {
        private int x = 6;
        public void show() {
            int x = 7;
            System.out.println("x: " + x);
            System.out.println("Inner x: " + this.x);
            System.out.println("Outer x: " + Outer.this.x);
        }
    }
}

/*
class Person {
    private String name;
    private int age;

    class Heart {
        private String leftVentricle;
        private String rightVentricle;
        private String left心房;
        private String right心房;
    }
}
*/


