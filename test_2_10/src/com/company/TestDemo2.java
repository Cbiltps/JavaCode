package com.company;

/**
 * 自定义异常 MyException
 * 继承于Exception的是受查异常（编译时异常）
 */
class MyException extends Exception{ // 自己定义异常必须继承一个异常
    public MyException(String message) { // 提供构造方法方便下面给参数
        super(message);
    }
}

/**
 * 自定义异常 MyException2
 * 继承于RuntimeException的是非受查异常（运行时异常）
 */
class MyException2 extends RuntimeException {
    public MyException2(String message) {
        super(message);
    }
}

public class TestDemo2 {
    /**
     * 受查异常用 try catch 包裹
     * @param x
     */
    public static void func1(int x) {
        try {
            if(x == 0) {
                throw new MyException("haha");
            }
        }catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("haha over");
    }

    /**
     * 或者是在后面throws
     * @param x
     * @throws MyException
     */
    public static void func2(int x) throws MyException {
        if(x == 0) {
            throw new MyException("heihei");
        }
    }

    public static void func3(int x) throws MyException2 {
        try {
            if(x == 0) {
                throw new MyException2("lala");
            }
        }catch (MyException2 e) {
            e.printStackTrace();
        }
        System.out.println("lala over");
    }

    public static void func4(int x) {
        if(x == 0) {
            throw new MyException2("heihei");
        }
    }

    /**
     * 对下面进行各种测试
     * @param args
     */
    public static void main(String[] args) {
        func1(0);
//        func2(0);
        func3(0);
        func4(0);
    }
}