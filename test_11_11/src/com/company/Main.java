package com.company;

public class Main {

    /**
     * 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字（建议画图）
     * @param array 传参的数组
     * @return 注意返回的ret
     */

    public static int findNum(int[] array) {
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            ret = ret ^ array[i];//这里的步骤和 交换律 类似
            //大概思路是这样的：
            //1 ^ 1 = 0
            //0 ^ 1 = 1
            //1 ^ 2 ^ 3 ^ 2 ^ 1 = 3
        }
        return ret;
    }

    public static void main(String[] args) {
	    int[] array = {1,2,3,4,3,2,1};
        System.out.println(findNum(array));
    }
}
