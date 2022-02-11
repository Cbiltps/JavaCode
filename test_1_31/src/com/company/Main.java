package com.company;

//这个是 博客的素材

import java.util.Arrays;

public class Main {
    /*public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + "llo";//此时 他两都是常量，编译的时候，就已经确定好了是"hello"
        String str3 = "he";
        String str4 = str3 + "llo";//此时str3是一个变量 -》编译的时候，不知道是啥？ str4不是一个完整的对象！
        *//*拼接的hello并不是在常量池里面，拼接的是一个单独的对象！*//*
        System.out.println(str1 == str4);
    }*/

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
        /*这里肯定就是true了!*/
    }
}




    /**然后下面做一点铺垫（涉及到JVM的知识）：
    *
    * Class文件常量池：Class文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量
    * 池表（Constant Pool Table），用于存放编译期生成的各种字面量与符号引用，这部分内容将在类加
    * 载后存放到方法区的运行时常量池中。
    *
    * 运行时常量池：当程序把编译好的字节码文件加载到JVM当中后，会生成一个运行时常量池（在方法区，就是从磁盘到内存），
    * Class文件常量池会变成运行时常量池。
    *
    * 字符串常量池：本质是一个哈希表（StringTable），JDK1.8开始放在了堆里面，里面存的是驻留字符串的引用，
    * 在堆中的字符串实例被这个哈希表引用之后就等同被赋予了”驻留字符串”的身份，
    * 在JVM中字符串常量池被所有类共享。
    *
    * 什么是哈希表:其实就是一个数据结构，描述和组织数据的一种方式，非常的块！
    */


//    public static void main(String[] args) {
//        String str1 = "11";
//        String str2 = new String("1") + new String("1");//这里创建的对象是StringBuilder对象!
//        System.out.println(str1 == str2);
//        System.out.println(str2);
//    }


//    public static void main(String[] args) {
//        String str2 = new String("1")+new String("1");
//        str2.intern();//手动入池
//        String str1 = "11";
//        System.out.println(str1 == str2);
//    }



   /* public static void main(String[] args) {
        String str1 = null;
        *//*使用equals的时候要注意：一定要预防空指针异常！*//*
        String str2 = "11";//如果想要修改的话，就必须通过反射修改
//        System.out.println(str1.equals(str2));//这样子就是空指针异常
        System.out.println(str2.equals(str1));//这里的str2不是空指针，就不会报错的
    }*/