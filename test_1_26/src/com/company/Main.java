package com.company;

/*字符 字节 字符串之间的转换*/

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String str = "Java30 12&21#hello";
        String[] strings = str.split(" |&|#");//如果一个字符串中有多个分隔符，可以用"|"作为连字符
        for (String s:strings) {
            System.out.println(s);
        }
    }


    public static void main8(String[] args) {
        /*字符串拆分*/
        String str = "name=zhangsan&age=19";
        String[] strings = str.split("&");//以 &符号 分割
        for (String s:strings) {
//            System.out.println(s);
            String[] s2 = s.split("=");//再一次分割
            for (String tmp :s2) {
                System.out.println(tmp);
            }
        }

        System.out.println("=================");

        /*特殊的东西（点）*/
        String str2 = "192.168.1.1";
        String[] strings2 = str2.split("\\.");//.符号比较特殊需要转义 但是\也比较特殊需要再次转义
        //还有其他的字符也要注意转义，记得去看PDF课件...
        for (String s3:strings2) {
            System.out.println(s3);
        }

        String str3 = "192.168.1.2";
        String[] strings3 = str3.split("\\.",2);//分两组，但是是不均匀的
        for (String s4:strings3) {
            System.out.println(s4);
        }

        System.out.println("=================");

        /*遇见下面情况的时候要注意*/
        String str4 = "192\\168\\1\\1";
        strings = str2.split("\\\\",7);
        for (String s:strings) {
            System.out.println(s);
        }
    }


    public static void main7(String[] args) {
        /*字符串替换*/
        String str = "ababcabcdabcde";
        String ret = str.replace("ab","pp");
        System.out.println(ret);
    }


    public static void main6(String[] args) {
        String str = "ababcabcd";
        String tmp = "abc";

        System.out.println(str.lastIndexOf(tmp));
        System.out.println(str.lastIndexOf(tmp,4));//从第四个位置开始从后往前找
        System.out.println(str.startsWith("a"));//是否是以a开头的字符串
        System.out.println(str.startsWith("c",4));//从第四个位置开始找c开头的字符串
        System.out.println(str.endsWith("cde"));//判断以cde结尾的
    }


    public static void main5(String[] args) {
        String str = "ababcabcd";
        String tmp = "abc";
        boolean flg = str.contains(tmp);
        System.out.println(flg);

        System.out.println("==============");

        int index = str.indexOf(tmp);//类似于C的strstr  也就是->  KMP算法
        System.out.println(index);//显示开始的位置下标

        int index2 = str.indexOf(tmp,3);//从第三个位置开始找
        System.out.println(index2);//显示开始的位置下标
    }


    public static void main4(String[] args) {
        /*这一部分是 字符串的比较 有两种方式 一起看下面的
        * 1：真假比较
        * 2：大小比较*/

        /*真假比较*/
        String str1 = "Abc";
        String str2 = "sad";
        System.out.println(str1.equals(str2));

        String abc = "ABC";
        String abc1 = "abc";
        System.out.println(abc.equalsIgnoreCase(abc1));//忽视字母大小比较

        /*大小的比较*/
        String str3 = "Abc";
        String str4 = "abc";
        int ret = str3.compareTo(str4);//方法源代码我直接贴在下面 里面有注释
        System.out.println(ret);


        /*重写compareTo方法*/

       /* public int compareTo(String anotherString) {
            int len1 = value.length;
            int len2 = anotherString.value.length;
            int lim = Math.min(len1, len2);//取的是两个长度的最小值
            char v1[] = value;//把两个字符串都变成数组进行比较
            char v2[] = anotherString.value;

            int k = 0;
            while (k < lim) { //有意思的就是k和lim比较
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;//返回相减的值
                }
                k++;//位置加
            }
            return len1 - len2;
        }*/



        /*然后compareTo的返回值有三种情况，其实中文也是可以比较的
        * 1；>0
        * 2：==0
        * 3：<0 */


        /*下面的是equals的源代码！
       * 谁调用equals谁就是this！这一点要注意*/

       /* public boolean equals(Object anObject) {
            if (this == anObject) { //这里是判断地址是是否一样
                return true;
            }
            if (anObject instanceof String) { //有这段代码就可以判断 是不是同类型比较
            //注意写博客的时候，把博哥画的图字节贴上去 方便理解
                String anotherString = (String)anObject;//把元素变成字符串
                int n = value.length;
                if (n == anotherString.value.length) { //长度不一样就直接进不来
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) { //每一个进行比较
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }*/
    }


    public static void main3(String[] args) throws UnsupportedEncodingException {
        //字节与字符的转换
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);

        byte[] bytes2 = {97,98,99,100};
        /*String str2 = new String(bytes,13);//这样写是没有意义的*/
        String str2 = new String(bytes,1,3);//起始点和长度
        System.out.println(str2);

        System.out.println("===============");

        String str3 = "abcd";
        byte[] bytes3 = str3.getBytes();
        System.out.println(Arrays.toString(bytes3));

        /*还有另外一个getBytes 编码转换处理！*/

        String str4 = "祥子";
        byte[] bytes4 = str4.getBytes(StandardCharsets.UTF_8);//UTF_8编码
        System.out.println(Arrays.toString(bytes4));

        String str5 = "祥子";
        byte[] bytes5 = str5.getBytes("GBK");
        System.out.println(Arrays.toString(bytes5));

        /*其实就是 同样的字符串编译英文的时候是一样的 但是 中文的时候随着编码方式不同而不同！*/
        /*写博客的时候，记得看PDF课件上的小节！*/
        /*其中的文件的格式什么的，在C语言讲过的，但是，我还没有听！ 草！*/

    }




    //  这是一条单独笔记（不知道放在哪里）  哈希表理解：底层就是一个数组，数组的元素（数据）就是链表，数据是单用链表串起来的！




    public static boolean isNumberChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断某个字符是不是数字
            boolean flg = Character.isDigit(c);
            if(!flg) {
                return false;
            }
           /* if(c < '0' || c > '9') { //
                return false;
            }*/
        }
        return true;
    }
    /*作业：自己学习Character，比如判断字符是不是字母...*/

    public static void main2(String[] args) {
        /*给定一个字符串，判断是否是由数字组成！*/
        String str = "124567";
        System.out.println(isNumberChar(str));
    }

    public static void main1(String[] args) {

        /*将数组转换成字符串*/
        char[] val = {'a', 'b','c'};
        String str = new String(val);
        System.out.println(str);

        /*上面的例子是把数组的整体变成字符串，部分也是可以的！*/
        char[] val2 = {'a', 'b', 'c', 'd', 'e'};
        String str2 = new String(val2, 1,3);//取第一个位置到第三个位置
        System.out.println(str2);//打印出来 bcd

        System.out.println("=====================");

        /*取到字符串的某一个字符*/
        String str3 = "hello";
        char ch = str3.charAt(2);//获取到下标为2的字符
        System.out.println(ch);

        /*把整个字符串变成数组*/
        char[] charArray = str3.toCharArray();//把str3指向的字符串对象变成数组
        System.out.println(Arrays.toString(charArray));//字符串的方式打印数组
    }
}
