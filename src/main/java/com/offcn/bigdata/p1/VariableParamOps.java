package com.offcn.bigdata.p1;

/**
 * java中的可变参数
 */
public class VariableParamOps {
    public static void main(String[] args) {
        int[] aa = {1, 2 , 3};
        System.out.println(add(aa));
    }
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
//        return add(add(a, b), c);
        return a + b + c;
    }
//    public int add(int[] arr) {
//        int sum = 0;
//        for(int i : arr) {
//            sum += i;
//        }
//        return sum;
//    }
    //可变参数
    public static int add(int... arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        return sum;
    }

}
