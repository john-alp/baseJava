package com.entertainments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Test {
    static List<Integer> may = new ArrayList<>();

    public static void main(String[] args) {


        for (int i = 0; i < 1_000_000; i++) {
            may.add(i);
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println(may);


    }


    //    static List<Object> l;
//    public static void main(String... args) throws InterruptedException {
//        Thread.sleep(10_000);
//        l = new ArrayList<>();
//        for (int i = 0; i < 100_000_000; i++) {
//            l.add(new Object());
//        }
//
//        int n = 1;
//
//        int l = 8;
//        int p = l;
//        int[] mas = {1, 4, 7, 8, 2, 9, 6, 14, 89};
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < l; j++) {
//                mas[j] = mas[j + 1];
//
//            }
//        }
//
//        for (int i = 0; i < mas.length; i++) {
//            System.out.printf("%3d", mas[i]);
//        }


}
