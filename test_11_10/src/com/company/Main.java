package com.company;

public class Main {

    /**
     *获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
     * 这道题一定要画图
     * @param n 传参的值
     */

    public static void printOne(int n) {
        //奇数
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n >> i) & 1)+ " ");
        }

        System.out.println();

        //偶数
        for (int j = 31; j >= 1; j -= 2) {
            System.out.print(((n >> j) & 1)+" ");
        }
    }

    public static void main(String[] args) {
	    printOne(11);
    }
}
