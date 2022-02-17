package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * 这是一个注意点 关于finally：尽量避免在finally中写return语句
     * 这样的话你就不知道返回的是 a 还是 20 了。
     * @return
     */
    public static int func() {
        int a = 10;
        try {
            //System.out.println(10/0);
            return a;
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }finally {
            return 20;// 这里是返回20的
        }
    }

    public static void main(String[] args) {
        System.out.println(func());
    }

   /* public static void func2(int n) throws ArithmeticException{
        try {
            System.out.println(10/n);
        }catch (ArithmeticException e) {
            System.out.println("func2()");
            e.printStackTrace();
        }
        // System.out.println(10/n);
    }

    public static void main(String[] args) {
        try {
            func2(0);
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("main()");
        }
        System.out.println("ffsad");
    }*/

    /**
     * 如果本方法中没有合适的处理异常的方式, 就会沿着调用栈向上传递
     * @param n
     * @throws ArithmeticException
     */
    public static void func(int n) throws ArithmeticException { // throws一下 告诉调用者会有异常
      try { // 这个和下面main函数的try都是一样的，效果就是双重保险
            System.out.println(10/n);
        } catch (ArithmeticException e) {
          e.printStackTrace();
          System.out.println("方法内处理异常");
        }
//        System.out.println(10/n);
    }

    /**
     * 如果向上一直传递都没有合适的方法处理异常, 最终就会交给 JVM 处理, 程序就会异常终止
     * 和我们最开始使用 try catch 时是一样的!
     * @param args
     */
    public static void main9(String[] args) {
        // 假如你知道这个函数会有异常
        try {
            func(0);
        } catch (ArithmeticException e) {
            e.printStackTrace();// 这个时候运行的时候就是交给JVM了
            System.out.println("main内处理");
        }
        System.out.println("检测执行执行完毕");
    }

    public static void main8(String[] args) { // 这就是把资源放进try里面了
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        } finally {
            // 上面没有catch除以0的异常，输入0的时候，进行测试...
            // 这里有一点记住：catch没有捕捉到，最后的finally也是可以执行的
            System.out.println("finally执行了！");
        }
    }

    //当然还有一种写法就是 直接把代码写进try里面 这样后面的close代码就会自动执行
    public static void main7(String[] args) { // 这就是把资源放进try里面了
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常，可能0作为了除数");
        } finally {
            // 一般作为，资源的关闭
            // 在这里我们要合理使用它，有的时候不是一定要finally，if条件语句也是可以的
            // 如果要细分一下的话，类似于参数的使用if条件语句；业务的处理就使用finally
            System.out.println("finally执行了！");
        }
    }

    //可以写成上面的样子，把语句写进try里面
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            System.out.println(10/n);
        }catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常，可能0作为了除数");
        }finally { // 一般作为，资源的关闭
            scanner.close();
            System.out.println("finally执行了！");
        }
    }

    //博哥的笔记里面有捕捉的顺序的记录 写博客的时候去看一下
    public static void main5(String[] args) {
        int[] array = {1,2,3};
        try {
            //array = null;
            System.out.println(array[21]);
            System.out.println("haha!");
        }catch (Exception e) { // 可以直接catch这个父类 但是不建议这样做 因为它的子类太多了
            e.printStackTrace();
            System.out.println("fsafdaf");
        }/*catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("发生异常了！");
        }*/
        System.out.println("哈喽！！！");
    }


    // 发生异常后面的语句不会执行
    public static void main4(String[] args) {
        int[] array = {1,2,3};
        System.out.println(array[5]);
        System.out.println("检测是否执行");
    }

    // 这也发生一种异常 输入异常
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3};
        try {
            array = null;
            System.out.println(array[2]);
            System.out.println("haha!");
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e) { // 连续捕捉异常中间加“|”符号
            e.printStackTrace();
            System.out.println("我捕捉到了一个数组越界/空指针异常，这里开始处理异常了");
        }
        System.out.println("哈喽！！！");
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[9]);
        }catch (ArrayIndexOutOfBoundsException e) {
            /*一般情况下，catch内容要加，finally可加可不加！*/
            e.printStackTrace();// 打印异常信息栈
            System.out.println("捕获异常了！");
        }
        System.out.println("完毕！");
        /*运行出来的框框里，蓝色的字可以定位到代码的异常处！*/
        /*灰色代表的事源码错误了！*/
    }
}
