package com.company;

import java.lang.reflect.Field;

public class TestDemo {

    /*我们知道字符串是不可变的，如果一定要修改里面的值的话，就要利用反射！反射是一个技术手段，多用于框架中！*/
    /*简单的想一下，其实就是通过下标访问改变值就可以的，当是value值是private的，所以要通过反射！*/
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abcde";
        Class<?> c1 = String.class;
        // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
        Field valueField = c1.getDeclaredField("value");
        // 将这个字段的访问属性设为 true
        valueField.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[]) valueField.get(str);
        // 修改 value 的值
        value[0] = 'h';
        System.out.println(str);
    }


    /*public static void main(String[] args) {
        *//*效率低！会产生很多的对象！*//*
        *//*字符串的拼接会被优化为StringBuilder对象！*//*
        String str = "abcde";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        System.out.println(str);
    }*/

  /*  public static void main(String[] args) {
        *//*字符串的拼接非常费效率！*//*
        String str = "hello" ;
        str = str + " world" ;
        str += "!!!" ;
        System.out.println(str);
    }*/
}
