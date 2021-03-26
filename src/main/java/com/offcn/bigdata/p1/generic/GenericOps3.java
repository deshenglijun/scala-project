package com.offcn.bigdata.p1.generic;

import com.offcn.bigdata.scala.p4.collection.Person;

import java.util.Arrays;

/**
 * 复习java中的泛型
 */
public class GenericOps3 {
    public static void main(String[] args) {
        Integer[] iArray = {3, -6, 2, 0, 9, 5, 8, 1};
        Float[] fArray = {3f, -6f, 2f, 0f, 9f, 5f, 8f, 1f};
        Double[] dArray = {3d, -6d, 2d, 0d, 9d, 5d, 8d, 1d};
        System.out.println("i排序前的数组：" + Arrays.toString(iArray));
        System.out.println("f排序前的数组：" + Arrays.toString(fArray));
        System.out.println("d排序前的数组：" + Arrays.toString(dArray));
        Tool3.insertSort(iArray);
        Tool3.insertSort(fArray);
        Tool3.insertSort(dArray);
        Person[] persons = {
                    new Person("fan雅骞", 14),
                    new Person("sun文文", 17),
                    new Person("tian军洋", 15),
                    new Person("wei超", 18),
                    new Person("old李", 38)
        };
        Tool3.insertSort(persons);
        System.out. println("i排序后的数组：" + Arrays.toString(iArray));
        System.out. println("f排序后的数组：" + Arrays.toString(fArray));
        System.out. println("d排序后的数组：" + Arrays.toString(dArray));
        System.out. println("person排序后的数组：" + Arrays.toString(persons));
    }
}

/*
对多种类型的数据进行排序，如果使用下面构造多个相同业务逻辑的方法的话，是一种非常不友好的编程方式
升级：泛型
    但是使用了泛型却报错了：(array[j] < array[j - 1]，无法进行比较，原因在于并不是所有的类型都可以进行这种 > < >= <=的操作，
    现在要使用以中更加广泛的比较方式————java中就是Comparable，
    所以这就要求这个泛型要么是Comparable，要么是Comprable的子类。
    所以在定义泛型的时候，就变成了：<T extends Comparable<T>> --->泛型的上限限定

再升级：
    上述在类上定义的通用的可比较的泛型，有一个缺陷，当在定义并确定类型之后，便只能对同一种类型进行处理，要想对其他的类型进行处理，只能
    重新创建对象，仍然显得不够完美，我们最好做到，只需要一个对象，便可以处理各种数据，或者不需要对象，或者静态来完成对各种数据的处理。

    为了完成这个业务需求，就得需要更加灵活的泛型——方法上的泛型，其和类上面定义的泛型没有关系。

 */
class Tool3 {
    public static <T extends Comparable<T>> void insertSort(T[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j].compareTo(array[j - 1]) > 0) break;
                swap(array, j, j - 1);
            }
        }
    }

    private static <T> void swap(T[] array, int j, int i) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
