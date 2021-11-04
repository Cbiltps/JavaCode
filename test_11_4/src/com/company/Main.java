package com.company;

import java.util.Scanner;

public class Main {

    /**
     * 出租车计费
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("请输入你的公里数：");
        Scanner scanner = new Scanner(System.in);
        double rode = scanner.nextDouble();

        if (rode <= 3) {
            System.out.println(rode + "公里的费用是8元！");
        }else {
            double sum = 8 + (rode - 3)*2;
            System.out.println(rode + "公里的费用是" + sum + "元！");
        }
    }
}
