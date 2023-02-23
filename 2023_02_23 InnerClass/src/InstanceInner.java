/**
 * Created with IntelliJ IDEA.
 * Description:
 * 板书链接: https://gitee.com/gaobo1/java-102/blob/master/102-%E6%9D%BF%E4%B9%A6/2022-02-22-%E5%93%88%E5%B8%8C%E8%A1%A8.png
 * User: Cbiltps
 * Date: 2023-02-23
 * Time: 14:30
 */

class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    /**
     * 实例内部类: 你可以把他当做是外部类的一个普通实例的成员
     * 内部类生成的class文件:
     *     一般一个类会生成一个class文件, 但是内部类生成的class文件是:OuterClass$InnerClass.class
     *
     * 再注意:
     *     虽然看上去InnerClass在OuterClass里面了,
     *     但是类本身是单独的!
     *     比如OuterClass extends A,
     *     但是, A和InnerClass没有关系!
     */
    class InnerClass {
        public int data1 = 999999;
        public int data4 = 4;
        private int data5 = 5;
//        public static int data6 = 6;// error, 实例内部类中无法写静态属性
        // InnerClass类是依赖对象的, 但是静态属性不依赖对象!
        public static final int data6 = 6;// 如果非要定义静态属性, 只能定义静态常量!

        public InnerClass() {
            System.out.println("不带参数的内部类的构造方法！");
        }

        public void test() {
            /*
            实例内部类当中, 如果包含了和外部类同名的成员变量, 如何在实例内部类中访问?
             */
            System.out.println(OuterClass.this.data1);
            /*
            上面的问题是如何考的:
                实例内部类当中是否拥有外部类的this?
                也就是说, 实例内部类当中实际上有两个this,
                一个是外部类的this,
                一个是自己的this.
             */

            System.out.println(this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }

    public void func() {
        //static int a = 10; //静态属性是属于(依赖-通过类名调用)类的, 不属于对象
        System.out.println("OuterClass::func()");
    }
}

/**
 * 当时写链表的时候, 就可以写内部类.
 *
 * 一般什么情况下设计成内部类?
 *     xxx东西由xxx组成,
 *     比如: 链表是由结点组成的, 类似这样的关系.
 *     当然, 不设计成内部类也是没有关系的!
 */
class MyLinkedList {
    class Node {

    }
}

public class InstanceInner extends OuterClass.InnerClass {
    // 想要继承内部类, 就要写继承者的构造方法!
    public InstanceInner(OuterClass outerClass) {
        outerClass.super();
    }


    /**
     * 本地内部类: 定义在方法当中的类
     * 缺点: 只能在当前方法当中使用
     * @param args
     */
    /*public void func() {
        class Test {
            public int a;
        }
    }*/


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();// 这样可以拿到普通外部类的对象
        outerClass.func();
//    InnerClass innerClass = new InnerClass();// error, 如何获取实例内部类的对象?
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();// 获取实例内部类的对象
        innerClass.test();
    }
}
