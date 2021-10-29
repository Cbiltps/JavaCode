package com.company;

import java.util.Arrays;//这个包的方法是关于数组的
import java.util.Random;//这个包的方法可以创建随机数

public class Main { //主类

    //冒泡排序方法
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) { //前一个数大于后一个数的时候交换
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;//返回这个数组
    }

    public static void main(String[] args) {

        //1到100的和
//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            sum += i;
//        }
//        System.out.println(sum);

        /**
         * 初始化一个数组 元素是100个随机值（范围在1到1000之间） 并且使用冒泡排序（显示升序）
         */
        int[] array = new int[100];//初始化数组，有100个元素
        Random random = new Random();//创建随机数对象
        for (int i = 0; i < 100 ; i++) {//100个元素
            int j = random.nextInt(1000);//范围在1000内
            array[i] = j;//给数组赋值
        }

        System.out.println(Arrays.toString(bubbleSort(array)));//调用方法以字符串的方式打印数组
    }
}
