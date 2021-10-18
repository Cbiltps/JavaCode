package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //1到100中有几个9
//        int count = 0;//计数器
//
//        for(int num = 1; num <= 100; num++) {
//
//            //判断各位是否有9
//            if(num % 10 == 9) {
//                count++;
//            }
//
//            //判断十位是否有9
//            if(num / 10 == 9) {
//                count++;
//            }
//        }
//        System.out.println(count);

        //计算 1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
//        double n = 1.0d;//分子
//        double i = 1.0d;//分母
//        double sum = 0.0d;
//
//        for(i = 1; i <= 100; i++) {
//            sum += n / i;
//            n = -n;
//        }
//        System.out.println("表达式的值为："+sum);

        //求一个整数，在内存当中存储时，二进制1的个数
        int count = 0;//计数器

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");

        int num = sc.nextInt();
        for(int i = 0;i < 32;i++) {
            if(((num >> i) & 1) == 1) {
                count++;
            }
        }
        System.out.println("这个数在存储时有"+count+"个1");
    }
}
