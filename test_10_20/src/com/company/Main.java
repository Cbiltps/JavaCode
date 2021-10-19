package com.company;

import java.util.Scanner;

/**
 * 编写代码模拟三次密码输入的场景，最多能输入三次密码。
 * 密码正确，提示“登录成功”；
 * 密码错误，可以重新输入，最多输入三次。
 * 三次均错，则提示退出程序。
 */

public class Main {

    public static void Login() {

        Scanner scanner = new Scanner(System.in);
        int count = 3;//三次机会
        while(count != 0) {
            System.out.print("请输入你的密码：");
            String passWord = scanner.nextLine();

            if(passWord.equals("123456")) { //比较两个字符串相同的方法
                System.out.println("你登陆成功了！");
                break;
            }else {
                count--;
                System.out.println("你输错了，你还有"+count+"次机会！");
            }
        }

    }

    public static void main(String[] args) {
        Login();
    }
}
