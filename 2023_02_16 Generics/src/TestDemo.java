import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-02-16
 * Time: 15:01
 */

class MyArray1 {
    // 用Object类型创建数组就能达到通用的目的
    public Object[] objects = new Object[10];

    public void set(int pos, Object val) {
        objects[pos] = val;
    }

    public Object get(int pos) {
        return objects[pos];
    }
}

/**
 * 使用泛型之后
 * @param <T> 此时代表当前类是一个泛型类 T:当做是一个占位符
 */
class MyArray<T> {

    //public T[] objects = new T[10];// 这里会报错, 不能实例化泛型类型的数组

    public T[] objects = (T[])new Object[10];// 这样虽然不报错了, 但是不能这样写, 创建泛型数组只能用反射的方式
    //public Object[] objects = (Object[])new Object[10];// 上一句代码的原型是这样的, 它本来就是Object[], 何必再转化?
    // 而且会发生 main3 中的情况!

    public void set(int pos,T val) {
        objects[pos] = val;
    }

    public T get(int pos) {
        return objects[pos];
    }

    // 因为返回的是Object[], 所以什么类型都可以放
    public T[] getArray() {
        return objects;
    }

}

/**
 * 介绍一种特殊的上界:
 * 写一个泛型类，求出数组当中的最大值
 * @param <T>
 */
class Alg<T extends Comparable<T>> {
    public  T findMax(T[] array) {
        T max = array[0];// 假设第一个元素为最大值
        for (int i = 1; i < array.length; i++) {
            // 这里为什么会报错?
            // if(max < array[i]) {
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

/**
 * 静态的泛型方法不依赖类, 所以创建类的时候不用写 class Alg<T extends Comparable<T>> 了,
 *     要在static后面写上界:  static<T extends Comparable<T>>
 */
class Alg2 {
    public static<T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            // 这里为什么会报错？
            // if(max < array[i]) {
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg3  {
    public static <T> void print1(ArrayList<T> list) {
        for (T x : list) {
            System.out.println(x);
        }
    }

    public static void print2(ArrayList<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }
}

class A {

}
class Person extends A{

}
class Student extends Person {

}
class C extends Student {

}

public class TestDemo {
    public static void main1(String[] args) {
        MyArray1 myArray = new MyArray1();
        myArray.set(0, "hello");
        myArray.set(1, 10);
        // 这样就有两个问题:
        // 1. 存放元素什么类型都可以存放
        // 2. 取元素必须要强制类型转换
        // 所以, 要达到 通用 的目的并解决这两个问题, 就要引入泛型!
        String str = (String) myArray.get(0);
    }

    public static void main2(String[] args) {
        MyArray<String> myArray = new MyArray<String>();// 第二个尖括号里的String可以写, 也可以不写
        myArray.set(0, "hello");
        //myArray.set(1, 10); 1、编译的时候，自动进行类型的检查
        String str = myArray.get(0);//2、不需要手动进行类型的强制转换, 编译器会自动帮我们进行类型的转换
        MyArray<Integer> myArray2 = new MyArray<Integer>();
        //MyArray<int> myArray3 = new MyArray<int>(); 简单类型/基本类型不能作为泛型类型的参数

        // 如果当前类是泛型类, 但是在创建类的时候没有在尖括号注明类型, 此时就是 裸类型(Raw Type), 不要使用
        MyArray myArray3 = new MyArray();
        myArray3.set(0,"hello");
        myArray3.set(1,10);
        String str2 = (String) myArray3.get(0);

    }

    public static void main3(String[] args) {
        MyArray<String> myArray = new MyArray<>();
//        String[] ret = myArray.getArray();// 代码没有错误提示, 但是在运行的时候却抛异常了
        // 因为getArray()方法中返回的是T[]类型, 但是会转化为Object[], 所以什么类型都可以放, 你凭什么拿String[]接受它?
        // 所以, 编译器认为它是不安全的!

        // 建议用Object接收
        Object[] ret = myArray.getArray();
    }

    public static void main4(String[] args) {

        /*
        class MyArray<T extends Number> { // 这里就是指定泛型边界, 没有指定类型边界, 可以视为 E extends Object

            //public T[] objects = new T[10];// 这里会报错, 不能实例化泛型类型的数组

            public T[] objects = (T[])new Object[10];// 这样虽然不报错了, 但是不能这样写, 创建泛型数组只能用反射的方式
            //public Object[] objects = (Object[])new Object[10];// 上一句代码的原型是这样的, 它本来就是Object[], 何必再转化?
            // 而且会发生 main3 中的情况!

            public void set(int pos,T val) {
                objects[pos] = val;
            }

            public T get(int pos) {
                return objects[pos];
            }

            // 因为返回的是Object[], 所以什么类型都可以放
            public T[] getArray() {
                return objects;
            }

        }
         */

        MyArray<String> myArrayS = new MyArray<>();// 编译错误, 因为 String 不是 Number 的子类型或 Number 本身
        MyArray<Integer> myArrayI = new MyArray<>();
        MyArray<Number> myArrayN = new MyArray<>();
        myArrayN.set(0, 10);
        myArrayN.set(0, 12.5);
    }

    public static void main5(String[] args) {
        Alg<Integer> alg1 = new Alg<Integer>();
        Integer[] array = {1, 12, 3, 4};
        System.out.println(alg1.findMax(array));

        Alg<String> alg2 = new Alg<>();
        String[] array2 = {"abc", "hello", "cdefgh"};
        System.out.println(alg2.findMax(array2));
    }

    public static void main6(String[] args) {
        Integer[] array = {1, 12, 3, 4};
        System.out.println(Alg2.<Integer>findMax(array));// <Integer>可以写, 可以不写, 不写的时候可以根据array的类型推导出来
        System.out.println(Alg2.findMax(array));
    }

    /**
     * 泛型中的父子类关系
     * @param args
     */
    public static void main7(String[] args) {
        // MyArrayList<Object> 不是 MyArrayList<Number> 的父类型
        // MyArrayList<Number> 也不是 MyArrayList<Integer> 的父类型
        Alg<Integer> alg1 = new Alg<Integer>();
        System.out.println(alg1);

        Alg<Integer> alg2 = new Alg<Integer>();
        System.out.println(alg2);
        // 运行的时候, 在JVM里面是没有泛型的概念的, 运行出来的结果:
        // Alg@75b84c92
        // Alg@6bc7c054
        // 证明尖括号里的东西是被擦除的!
    }

    public static void main8(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        Alg3.print1(list1);
        System.out.println("--");
        Alg3.print2(list1);
    }

    public static void main9(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();

        List<? extends Number> list = arrayList1;
//        List<? extends Number> list2 = arrayList2;
//
//        list.add(0, 1);// error, 通配符的上界, 不适合写入数据
//        list.add(1, 10.9);// error
        // 此时list可以引用的子类对象很多, 编译器无法确定具体类型, 安全起见, java不让进行添加操作

        Number o = list.get(0);// 接受的时候, 可以用Number接收
//        Integer a = list.get(1);// error, 此时list可以引用的子类对象很多, 编译器无法确定具体类型, 安全起见, java不让用Integer接收

        // 总结: 使用通配符上界的时候, 为了安全起见, 只允许你读取!!!
    }

    public static void main(String[] args) {
        ArrayList<? super Person> arrayList1 = new ArrayList<Person>();
//        ArrayList<? super Person> arrayList2 = new ArrayList<Student>();// error, 只能引用Person或者Person父类类型

        arrayList1.add(new Person());
        //arrayList1.add(new A());// error
        arrayList1.add(new Student());//添加的元素, 是person或者person的子类
        arrayList1.add(new C());

        ArrayList<? super Person> arrayList3 = new ArrayList<A>();
        arrayList3.add(new Person());
        arrayList3.add(new Student());

//        Student student = arrayList3.get(0);// why?
//        Person person = arrayList3.get(0);// why? 上面的Student不能接收可以理解, 但是为什么Person不能接受?
        // 关于这个问题, 百度一下!

        Object o = arrayList1.get(0);//只能那object获取
    }
}
