package com.offcn.bigdata.p1;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException ame) {
            System.out.println("我ame了：" + ame.getMessage());
        } catch (Exception e) {
            System.out.println("我Exception了：" + e.getMessage());
        }
    }
}
