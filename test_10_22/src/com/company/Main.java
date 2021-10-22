package com.company;

import java.util.Scanner;

public class Main {

    /**
     * 求阶乘和
     * 求1！+2！+3！+4！+........+n!的和
     */
//    public static int  FactorialSum(int n) {
//        int Factorial = 1;
//        int sum = 0;
//        for (int i = 1; i <= n ; i++) {
//            Factorial *= i;
//            sum += Factorial;
//        }
//        return sum;
//    }

    /**
     * 求n的阶乘
     * @param n
     * @return
     */
//    public static int Factorial(int n) {
//        int Factorial = 1;
//        for (int i = 1; i <= n ; i++) {
//            Factorial *= i;
//        }
//        return Factorial;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("请输入n，将会求n！");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(Factorial(n));
//        }

    /**
     * 斐波那契函数
     */

    public static int Fibonacci(int n) {
        if((n == 0) || (n == 1)) {
            return n;
        }else {
            return (Fibonacci(n - 1) + Fibonacci(n - 2));
        }
    }

    public static void main(String[] args) {
        System.out.print("你想打印第几个斐波那契数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Fibonacci(n));
    }
}
