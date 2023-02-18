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

    //public T[] objects = new T[10];// 报错, 不能实例化泛型类型的数组
    // 而且在main3中为什么不能用String[]接收呢?
    // 因为getArray()方法中返回的是T[]类型, 但是会转化为Object[], 所以什么类型都可以放, 你凭什么拿String[]接受它?

    public T[] objects = (T[])new Object[10];// 这样虽然不报错了, 但是不能这样写, 因为编译器会把T转化为Object
    //public Object[] objects = (Object[])new Object[10];// 上一句代码的原型是这样的, 它本来就是Object[], 何必再转化?
    // 针对上面的注释, 那么问题来了, 泛型是如何编译的?
    // 答案看课件, 记得写在博客中!

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

    public static void main(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        String[] ret = myArray.getArray();
        // 虽然上面的代码没有错误提示, 但是在运行的时候却抛异常了
    }
}
