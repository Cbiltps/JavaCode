package com.company;

public class Main {

    //数组转字符串
//    public static String myToString(int[] array) {
//        if(array == null) {
//            return "null";
//        }
//
//        String str = "[";
//        for (int i = 0; i < array.length; i++) {
//            str = str + array[i];
//            if(i != array.length-1) {
//                str = str + ",";
//            }
//        }
//        str = str + "]";
//        return str;
//    }
//
//    public static void main(String[] args) {
//        int[] array = {1,2,3};
//        System.out.println(myToString(array));
//    }

    //数组求平均值
    public static double avg(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (double)sum / (double)arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(avg(arr));
    }
}
