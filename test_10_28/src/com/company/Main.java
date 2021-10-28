package com.company;

import java.util.Arrays;

public class Main {

    public static int myBinarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }else if (array[mid] < key) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(myBinarySearch(array, 7));

        //调用方法
        System.out.println(Arrays.binarySearch(array, 7));
    }
}
