import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 实例内部类和静态内部类那个好一点?
 *     静态内部类的好一点, 因为静态内部类不用实例化外部类对象(不访问外部类的普通成员变量的时候)!
 *     可以点开LinkedList/HashMap的源代码发现Node结点的实现都是静态内部类!
 * User: Cbiltps
 * Date: 2023-02-23
 * Time: 17:03
 */

class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    /**
     * 静态内部类: 你可以把他当做是外部类的一个静态的成员或方法, 调用它不需要外部类对象
     */
    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        /**
         * 方法一:
         * 直接初始化OuterClass2, 然后通过引用直接调用
         */
        public static OuterClass2 outerClass2 = new OuterClass2();


        /**
         * 方法二: 完成构造方法
         * 调用InnerClass构造方法(实例化内部类)的时候, 传入外部类对象的引用, 这样data1可以访问了
         */
//        public OuterClass2 outerClass2;
//        public InnerClass(OuterClass2 outerClass2) {
//            this.outerClass2 = outerClass2;
//        }


        public void test() {
//            System.out.println(data1);// error
//            System.out.println(data1);// error
            // 上面为什么不能访问?
            // 原因很简单, data1和data2的调用是依赖于外部类对象的引用,
            // 但是, InnerClass类调用不需要外部类对象!
            // 那如何才能访问外部类的普通成员变量?
//            System.out.println(outerClass2.data1);// 方法一或者方法二, 然后通过outerClass2引用调用
            System.out.println(outerClass2.data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }
}

public class StaticInner {
    public static void main(String[] args) {
//        OuterClass2 o = new OuterClass2();
        // 如何实例化静态内部类对象?
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();// 方法一: 不用实例化外部类对象
//        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass(o);// 方法二: 传入外部类对象的引用, 这样data1可以访问了
        innerClass.test();
    }
}
