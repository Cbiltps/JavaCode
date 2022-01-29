package com.company;

public class TestDemo {

    /*最后  这是一个全新的尝试 写博客的时候 就不是一边写博客一边听课的 这次是听课的时候不写博客
    * 就是写代码，最后写博客  看看效果如何！*/

    /*但是 回头的时候就还是要看一下课件的 里面有的东西是没有讲完的  自己完全可以看的！*/

    /*下一个  学习的就是 异常的课件的！加油！*/

    /**
     * 要注意返回类型的不同，然后看下面的例子
     * @return
     */
    public static StringBuffer func() {
        String str = new String("abc");
//        retuen str; //error  返回的类型是错误的
        return new StringBuffer(str);
    }


    /**
     * StringBuffer或者StringBuilder-》String
     * 调用toString方法
     * @return
     */
    public static String func2() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }


    /**
     * String->StringBuffer或者StringBuilder
     * 使用构造方法
     * @return
     */
    public static StringBuffer func3() {
        String str = "abcdef";
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        return sb;//可以直接返回 sb
        /*写博客的时候看课件的 顺序规划！*/
    }



    public static void main(String[] args) {

    }


    public static void main4(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        StringBuffer stringBuffer = new StringBuffer("abcdef");
        /*StringBuffer和StringBuilder的一些方法还是好用的！String就没有这样的方法！*/
        stringBuilder.reverse();//翻转
        System.out.println(stringBuilder);

        System.out.println("========");
        stringBuffer.reverse();
        System.out.println(stringBuffer);


        /*
         * 得出局部结论:
         * 如果是在循环里进行字符串的拼接，尽量不要使用String，
         * 优先使用StringBuffer和StringBuilder！
         *
         * 然后问一个局部的问题就是：
         * StringBuffer和StringBuilder有什么区别？
         *
         * 就是，StringBuffer用在多线程的情况下，StringBuilder用在单线程的情况下，
         * 不建议在单线程的情况下用StringBuffer，因为用的资源太多了
         *
         * */
    }



    /*main2的代码有一点问题 就是会产生大量的对象 所以下面这样写会更好！*/
    public static void main3(String[] args) {
        String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        str = sb.toString();
        System.out.println(str);
    }




    public static void main2(String[] args) {
        /*前面举的一个例子：底层就是这样实现的！*/
        String str = "abcdef";
        for (int i = 0; i < 10; i++) {
//            str += i;
            /*上面说过，这样会产生大量的临时对象，底层就是下面这样实现的！*/
            StringBuilder sb = new StringBuilder();
            sb.append(str).append(i);
            str = sb.toString();
        }
        System.out.println(str);
    }




    public static void main1(String[] args) {
        /*注意：注释中的是字面常用的代码，没有注释的是底层的代码！ 这就是一个字符串的相加*/
        //String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        //str += "123";//str = str + "123"
        sb.append("123");
        //str = sb.toString();
        System.out.println(sb);
    }
}
