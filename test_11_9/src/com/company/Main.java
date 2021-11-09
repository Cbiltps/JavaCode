package com.company;

public class Main {

    /**
     * 求最大公约数（利用辗转相除法） 这道题比较难理解
     * @param args 主函数的括号里的数组
     */

    public static void main(String[] args) {
	    int a = 24;
        int b = 18;
        int c = a % b; // 24 % 18 = 6
        while (c != 0) {
            a = b;//a = 18
            b = c;//b = 6
            c = a % b;
        }
        System.out.println("最大公约数是"+b);
    }
}
