package com.entertainments.algorithm;

public class Recursion {

    private static boolean status = true;
    private static int count = 1000;

    public static void main(String[] args) {
    start();
    }

    private static void start() {
        while (status) {
           // System.out.println(count = count - 1);
            count -= 1;

            StringBuffer stringBuffer = new StringBuffer();
            System.out.println(stringBuffer.append(count));

            if (count == 0) {
                    status = false;
            }
            start();
        }
    }
}
