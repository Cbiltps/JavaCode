package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //数组的整体赋值 只有1次机会 就是在定义的时候
        final int[] array = {1,2,3,4,5};
        //array = new int[]{4,5,6,7};
        String str1 = null;//str1这个引用 不指向任何对象
        String str2 = "";//str2这个引用 指向的字符串是空的
        System.out.println(str2.length());

    }


  /*  public static void main(String[] args) {
        String str1 = null;
        *//*使用equals的时候要注意：一定要预防空指针异常！*//*
        String str2 = "11";//如果想要修改的话，就必须通过反射修改
//        System.out.println(str1.equals(str2));//这样子就是空指针异常
        System.out.println(str2.equals(str1));//这里的str2不是空指针，就不会报错的
    }*/


 /*   public static void main(String[] args) {
        String str1 = "11";
        String str2 = new String("1")+new String("1");
        str2.intern();//手动入池-》当字符串常量池 没有的时候，才会入池
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));


        *//*注意课件上的是比较浅的，写博客的时候去看笔记！*//*
    }*/

/*
    public static void main(String[] args) {
        String str2 = new String("1")+new String("1");
        str2.intern();//手动入池
        String str1 = "11";
        System.out.println(str1 == str2);
    }*/


    /*public static void main(String[] args) {
        String str1 = "11";
        String str2 = new String("1") + new String("1");//这里创建的对象是StringBuilder对象!
        System.out.println(str1 == str2);
        System.out.println(str2);
        底层的实现是这样的！看图！
        画图非常重要的！
        StringBuilder
    }*/

   /* public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he"+"llo";//此时 他两都是常量，编译的时候，就已经确定好了是"hello"
        String str3 = "he";
        String str4 = str3+"llo";//此时str3是一个变量 -》编译的时候，不知道是啥？ str4不是一个完整的对象！
        *//*拼接的hello并不是在常量池里面，拼接的是一个单独的对象！*//*
        System.out.println(str1 == str4);
    }*/


    /*public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
        *//*这里肯定就是true了 记得写博客的时候也画一个图!*//*

    }*/

    /*public static void main4(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        *//*其实这里比较的不是内容，而是地址！ 地址不一样，运行的结果就是false！*//*

        *//*然后下面做一点铺垫（涉及到JVM的知识）：
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
        *
        * 写文章的时候记得画图！！！
        *
        * *//*
    }*/



/*    public static void func(String s,char[] array) {
        s = "gaobo";
        array[0] = 'p';
    }

    public static void main(String[] args) {
        String str = "abcdef";
        char[] chars = {'b','i','t'};
        func(str,chars);
        System.out.println(str);
        System.out.println(Arrays.toString(chars));
    }*/
    /*上面的问题，一定要画草图了解一下！里面牵扯较复杂的指向问题！*/
    /*所以说，不是 传引用 就是可以改变实的值！你要看这个引用到底干啥了！！*/


   /* public static void main(String[] args) {
        String str = "abcdef";
        String str2 = str;
        System.out.println(str);
        System.out.println(str2);
        *//*打印出来是一样的！博客的时候画一下内存图！*//*
        *//*其实这里的str和str2两个引用都是指向"abcdef"的，然后想一个问题，可以用str2修改"abcdef"吗？
        答案是不可以的，因为：它是字面值常量不能修改的!*//*

        str = "hello";//但是这里的修改是修改的指向！
        System.out.println("==============");
        System.out.println(str);
        System.out.println(str2);
        *//*打印出来不一样！博客的时候画一下内存图！*//*
    }*/




/*    public static void main(String[] args) {
	// C语言中没有字符串类型的，在C++和Java中有，叫String！
//        什么是字符串？ 使用双引号的   " "   可以若干字符   //字符串常量
//        什么是字符？   使用单引号     ''   只能有一个字符  //字符常量
//        注意： 在Java中没有 字符串以\0结尾 的说法！

        *//*直接打开String，进去看里面的代码，发现是final修饰的，说明不能被继承！*//*

        //定义：
        String str = "祥子";//字符串常量

        String str2 = new String("花花");//调用构造方法定义

        *//*把数组变成字符串*//*
        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars);
        System.out.println(str3);
    }*/
}
