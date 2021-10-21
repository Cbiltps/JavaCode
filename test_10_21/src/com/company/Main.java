package com.company;

import java.util.Scanner;

public class Main {
      /**
      * 输出一个整数的每一位
      * 如：123的每一位是 1 2 3
      */
//    public static void PrintPosition(int n) {
//
//        if(n > 9) {
//            PrintPosition(n / 10);
//        }
//        System.out.print((n % 10)+" ");
//    }
//
//    public static void main(String[] args) {
//        System.out.print("请输入一个数字：");
//        Scanner scanner  = new Scanner(System.in);
//        int num = scanner.nextInt();
//        PrintPosition(num);
//    }

    /**
     *输出n*n的乘法口诀表，n由用户输入
     */
    public static void table(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+(i * j)+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        System.out.print("请输入一个数字：");
        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();
        table(num);
//        for (int i = 1; i <= num; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.println(i+"*"+j+"="+(i * j)+"\t");
//            }
//            System.out.println();
//        }
    }
}
