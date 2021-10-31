package com.company;

public class Main {

    public static void main(String[] args) {

        //学习及博客所用到的代码    主题是：数据类型


//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//
//        int a;
//        System.out.println(a);
//
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Long.MIN_VALUE);

//        double num = 1.1;
//        System.out.println(num * num);

//        float a = 1.2f;
//        char a = '你';
//        char b = 97;
//        System.out.println(a);
//        System.out.println(b);
//        byte a = 130;

//        System.out.println(Short.MAX_VALUE);
//        System.out.println(Short.MIN_VALUE);
//
//        boolean a = false;
//        boolean b = true;

//        boolean value = true;
//        System.out.println(value + 1);

//        System.out.println("daxiangzi");
//        System.out.println("da"+"xiangzi");

//        System.out.println("hello"+10+20);

//        System.out.println(10+20+"hello");

//        System.out.println("hello"+(10+20));

//        System.out.println(10+""+20+"hello");//中间加一个空字符串即可

//        System.out.println("\"bit\"");

//        final int a = 10;
//        a = 20;

//        int a = 10;
//        long b = a;//这样写是可以的，int（四个字节）可以放到long（八字节）里
//        System.out.println(b);
//
//        long p = 12;
////        int q = p;//这样是错的，long无法放进int里（会损失精度），不能说是12不能放进int里
//
//        //但是如果一定要放进去，就要强制类型转换，这样有可能损失精度(有风险)
//        int q = (int)p;

//        int a = 10;
//        boolean b = a;//类型不匹配直接报错
//        boolean c = (boolean)a;//就算强制类型转换也不行

//        byte a = 1;
//        byte b = 2;
////        byte c = a + b;
//        //这里的byte是小于四个字节的，对于CPU来说，运算的时候会发生整型提升
//        //所以，a和b就是int类型，c是byte，类型不匹配就会报错
//
//        byte c = (byte)(a + b);
//        System.out.println(c);
//
//        byte c2 = 1 + 2;
//
//        int a = 10;
//        long b = 20;
////        int c = a + b;
//
////        int c = (int)(a + b);
//        long c = a + b;

//        int num = 10;
//        String ret = String.valueOf(num);//Java中可以直接调用方法把int转换成String
//        System.out.println(ret);
//
//        System.out.println(num+"");//这样也行，但是不可取

        String a = "123";
        int ret = Integer.valueOf(a);
        System.out.println(ret+1);

        //关于Java数据类型的学习就到这里！
        }
}
