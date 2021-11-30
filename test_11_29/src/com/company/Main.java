package com.company;

import com.xiangzi.test.TestDemo;//在上面导入包

import java.util.Date;

//这个是今天的学习日志，对于今天的部分知识点进行了简单的测试！

class TestDemo2 extends TestDemo {
    //这里是继承！
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Date date = new Date();//可以使用import导入 来获取一个时间戳
//        java.util.Date = new java.util.Date(); //这样子写的话比较麻烦
        System.out.println(date.getTime());//获取毫秒单位的时间戳

        TestDemo2 testDemo2 = new TestDemo2();
        System.out.println(testDemo2.val);
    }
}
