package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //一道百度的面试题：判断素数
        //注意：下面的代码是优化三次后的代码，前两次的没写，既然是面试题我觉的应该写一下的
        //想看前两次的代码，看第一次作业讲解的   时间：00_39_33
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;
        for (; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                System.out.println(n+"不是素数！");
                break;
            }
        }
        //二种情况
        if(i > Math.sqrt(n)) {
            System.out.println(n+"是素数！");
        }
    }
}
