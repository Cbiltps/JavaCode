package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //第二题：判断闰年
//        for(int i = 1000; i <= 2000; i++) {
//            //           判断普通闰年                  判断世纪闰年
//            if(((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
//                System.out.println(i);
//            }
//        }

        //第三题：判断范围内的素数
//        boolean isPrime = true;
//        for(int i = 2; i <= 100; i++) { //素数没必要判断1
//            for (int j = 2; j < i; j++) { //素数没必要判断1
//                if (i % j == 0) {
//                    isPrime = false;
//                }
//            }
//            if(isPrime) {
//                System.out.println(i);
//            }
//            isPrime = true;//当判断完一个数之后，isPrime的值重新赋成true，为了进行下一次判断
//        }

        //第四题：判断一个数是不是素数
//        int isPrime = 0;
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个大于1的数字");
//        int num = sc.nextInt();
//
//            for (int j = 2; j < num; j++) { //素数没必要判断1
//                if (num % j == 0) {
//                    isPrime++;
//                }
//            }
//
//            if(num == 1 || isPrime != 0) { //如果不小心输入1也可以
//                System.out.println(num + "不是素数");
//            }else {
//                System.out.println(num + "是素数");
//            }

        //第五题:switch判断年龄
//        while(true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("请输入年龄");
//            int age = sc.nextInt();
//
//            if(age < 0) {
//                System.out.println("输入错误，请重新输入");
//            }else if(age < 18) {
//                System.out.println("少年");
//                break;
//            }else if(age >= 19 && age <= 28) {
//                System.out.println("青年");
//                break;
//            }else if(age >= 29 && age <= 55) {
//                System.out.println("中年");
//                break;
//            }else {
//                System.out.println("老年");
//                break;
//            }
//        }

        //第六题：打印图形——抄的
//        System.out.println("请输入一个数字");
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            int n = sc.nextInt();
//            for(int i = 0; i < n; i++) {
//                for(int j = 1; j <= n; j++) {
//                    if(i == (j - 1) || (i + j) == n) {
//                        System.out.print("*");
//                    }else {
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println(" ");
//            }
//        }

        //第八题：水仙花
//        for(int i = 100; i <= 999; i++) { //水仙花数是指一个 3 位数,从100开始
//            int singleDigit = i % 10; //个位数
//            int tenDigit = i / 10 % 10; //十位数
//            int hundredDigit = i / 100; //百位数
//
//            if(hundredDigit * hundredDigit * hundredDigit + tenDigit * tenDigit * tenDigit + singleDigit * singleDigit * singleDigit == i) {
//                System.out.println(i+"是水仙花数");
//            }
//        }

        //第九题：最大公约数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个正整数");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for(int i = Math.min(num1, num2); i > 0; i--) {
            if(num1 % i == 0 && num2 % i == 0) {
                System.out.println("这两个数的最大公约数是"+i);
                break;
            }

        }
    }
}
