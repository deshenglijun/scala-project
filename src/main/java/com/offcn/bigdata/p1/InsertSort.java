package com.offcn.bigdata.p1;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {3, -6, 2, 0, 9, 5, 8, 1};
        System.out.println("排序前的数组：" + Arrays.toString(array));
        insertSort(array);
        System.out. println("排序后的数组：" + Arrays.toString(array));
    }

    /**
     * 插入排序：
     *    将一个元素插入到一个有序的集合中，使之重新有序，把这种排序方式称之为插入排序。
     *    特别的，集合只有一个元素的时候，是有序的。
     * 插入过程：（从小到大）
     *   3, -6, 2, 0, 9, 5, 8, 1
     * 从第二个元素开始遍历集合： i=1
     *    3, [-6], 2, 0, 9, 5, 8, 1
     * -->
     *    -6, 3, 2, 0, 9, 5, 8, 1
     * i = 2
     *    -6, 3, [2], 0, 9, 5, 8, 1
     * -->
     *     -6, [2], 3, 0, 9, 5, 8, 1
     *     -6, 2, 3, 0, 9, 5, 8, 1
     *i = 3
     *    -6, 2, 3, [0], 9, 5, 8, 1
     * -->
     *    -6, 2, [0], 3, 9, 5, 8, 1
     *    -6, [0], 2, 3, 9, 5, 8, 1
     *i=4
     *    -6, 0, 2, 3, [9], 5, 8, 1
     * -->
     *    -6, 0, 2, 3, 9, 5, 8, 1
     *i=5
     *    -6, 0, 2, 3, 9, [5], 8, 1
     *--->
     *    -6, 0, 2, 3, [5], 9, 8, 1
     *i=6
     *    -6, 0, 2, 3, 5, 9, [8], 1
     *--->
     *    -6, 0, 2, 3, 5, [8], 9, 1
     *i=7
     *    -6, 0, 2, 3, 5, 8, 9, [1]
     *--->
     *   -6, 0, 1, 2, 3, 5, 8, 9
     * @param array
     */
    private static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] > array[j - 1]) break;
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * ^：异或--相同为0，不同为1 => 0^0=0； 0^1=1； 1^0=1； 1^1=0；
     * 3的二进制0011 = a
     * 5的二进制0101 = b
     * a = a ^ b
     *   0011
     * ^ 0101
     * -----------
     *   0110 --6
     * b = a ^ b
     *   0110
     *^  0101
     *-----------
     *   0011 == 3
     * a = a ^ b
     *   0110
     * ^ 0011
     *------------
     *   0101 = 5
     */
    private static void swap(int[] array, int j, int i) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
