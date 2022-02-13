package com.company;

import java.util.Scanner;

public class Main {

    // 发生异常后面的语句不会执行
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(array[5]);
        System.out.println("其他的功能");
    }

    // 这也发生一种异常
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3};
        try {
            array = null;
            System.out.println(array[2]);
            System.out.println("haha!");
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e) { // 连续捕捉异常中间加“|”符号
            e.printStackTrace();
            System.out.println("我捕捉到了一个数组越界/空指针异常，这里开始处理异常了");
        }
        System.out.println("哈喽！！！");
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[9]);
        }catch (ArrayIndexOutOfBoundsException e) {
            /*一般情况下，catch内容要加，finally可加可不加！*/
            e.printStackTrace();// 打印异常信息栈
            System.out.println("捕获异常了！");
        }
        System.out.println("完毕！");
        /*运行出来的框框里，蓝色的字可以定位到代码的异常处！*/
        /*灰色代表的事源码错误了！*/
    }
}
