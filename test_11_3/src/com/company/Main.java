package com.company;

public class Main {

    /**
     * 求数组的最大值
     * @param array 数组
     * @return 返回最大值
     */

    public static int maxNum(int[] array) {
        if ((array == null) || (array.length == 0)) { //数组为空或者数组长度为0
            return -1;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,3,34,4,455,56};
        System.out.println(maxNum(array));
    }
}