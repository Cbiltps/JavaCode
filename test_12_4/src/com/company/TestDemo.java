package com.company;

import java.util.*;
//import static java.lang.System.*;
//import static java.lang.Math.*;


public class TestDemo {

    public static void main(String[] args) {
        TestDemo2 testDemo2 = new TestDemo2();
        System.out.println(testDemo2.val);
    }

    public static void main3(String[] args) {
        System.out.println("123");//不提倡这样写
        System.out.println(Math.max(12, 23));//不方便阅读，稀奇古怪

        com.cbiltps.test.TestDemo testDemo = new com.cbiltps.test.TestDemo();

    }

    public static void main2(String[] args) {
        java.util.Date date = new java.util.Date();
    }

    public static void main1(String[] args) {
	    int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));

        java.util.Date date = new java.util.Date();
    }
}
