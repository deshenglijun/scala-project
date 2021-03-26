package com.offcn.bigdata.p1.generic;

import java.util.Arrays;

/**
 * 复习java中的泛型
 */
public class GenericOps1 {
    public static void main(String[] args) {
        int[] iArray = {3, -6, 2, 0, 9, 5, 8, 1};
        float[] fArray = {3f, -6f, 2f, 0f, 9f, 5f, 8f, 1f};
        double[] dArray = {3, -6, 2, 0, 9, 5, 8, 1};
        System.out.println("i排序前的数组：" + Arrays.toString(iArray));
        System.out.println("f排序前的数组：" + Arrays.toString(fArray));
        System.out.println("d排序前的数组：" + Arrays.toString(dArray));
        Tool tool = new Tool();
        tool.insertSort(iArray);
        tool.insertSort(fArray);
        tool.insertSort(dArray);
        System.out. println("i排序后的数组：" + Arrays.toString(iArray));
        System.out. println("f排序后的数组：" + Arrays.toString(fArray));
        System.out. println("d排序后的数组：" + Arrays.toString(dArray));
    }
}
//对多种类型的数据进行排序，如果使用下面构造多个相同业务逻辑的方法的话，是一种非常不友好的编程方式
class Tool {
    public void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j - 1]) break;
                swap(array, j, j - 1);
            }
        }
    }

    public void insertSort(float[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j - 1]) break;
                swap(array, j, j - 1);
            }
        }
    }
    public void insertSort(double[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j - 1]) break;
                swap(array, j, j - 1);
            }
        }
    }

    private  void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private  void swap(float[] array, int j, int i) {
        float tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private  void swap(double[] array, int j, int i) {
        double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
