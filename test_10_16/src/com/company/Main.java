package com.company;

public class Main {

    //练习题：打印1到100之间能被3和5整除的数字

    public static void main(String[] args) {
        //while循环
//        int i = 1;
//        while(i <= 100) {
//            if(i % 3 == 0 && i % 5 == 0) {
//                System.out.println(i);
//            }
//            i++;

        //for循环
//        for(int i = 1; i <= 100; i++) {
//            if(i % 3 == 0 && i % 5 == 0) {
//                System.out.println(i);
//            }
//        }


        int i = 1;
        while(i <= 100) {
            if(i % 15 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
