package com.offcn.bigdata.p1;

import java.util.Arrays;
import static java.util.Collections.*;
import java.util.List;

/**
 * java中的静态导入
 *  1.5引入的
 */
public class StaticImportOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -3, 0, 9, 4, 6);
        //对list集合进行排序
        sort(list);
        System.out.println(list);

        wc: for(int i = 1; i< 10; i++) {
            for(int j = 1; j < 10; j++) {
                if(i == 6 && j == 4) {
                    break wc;
                }
                System.out.print("i=" + i + ", j=" + j + "\t");
            }
            System.out.println();
        }
    }
}
