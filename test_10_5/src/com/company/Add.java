package com.company;

import java.util.Scanner;

public class Add {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("请输入第一行数字：");
        int x = s.nextInt();

        System.out.println("请输入第二行数字：");
        int y = s.nextInt();

        System.out.println(x+y);

    }
}
