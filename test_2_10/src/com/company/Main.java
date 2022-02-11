package com.company;

public class Main {

    public static void main(String[] args) {
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
