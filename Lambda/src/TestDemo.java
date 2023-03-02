import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-02
 * Time: 08:23
 */

@FunctionalInterface
// 用@FunctionalInterface表示, 这是一个函数式接口
interface NoParameterNoReturn {
    void test();// 无返回值没有参数
    //void test2(); // error, 只有一个抽象方法
}

// 无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

// 无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}


// 有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

// 有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

// 有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class TestDemo {
    // 回顾一下之前学过的代码, 使用lambda表达式
    public static void main6(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        // 重写compare方法
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>(3, (o1, o2) -> o1-o2);
    }

    /**
     * 有返回值的时候
     * @param args
     */
    public static void main5(String[] args) {
        NoParameterReturn noParameterReturn = () -> {
            return 10;
        };
        // 简写之后
        NoParameterReturn noParameterReturn2 = () -> 10;
        int ret = noParameterReturn2.test();
        System.out.println(ret);

        // 一个参数
        OneParameterReturn oneParameterReturn = a -> a+11;
        System.out.println(oneParameterReturn.test(10));

        // 多个参数
        MoreParameterReturn moreParameterReturn = (a, b) -> a+b;
        System.out.println(moreParameterReturn.test(1, 2));
    }

    /**
     * 没有返回值的时候
     * @param args
     */
    public static void main(String[] args) {
//        OneParameterNoReturn oneParameterNoReturn = (a) -> {
//            System.out.println(a);
//        };
//        oneParameterNoReturn.test(10);
        // 上面的代码是可以优化成下面的(省略小括号和大括号)
//        OneParameterNoReturn oneParameterNoReturn = a -> System.out.println(a);
//        oneParameterNoReturn.test(10);

        int size = 10;
        size = 9;
        OneParameterNoReturn oneParameterNoReturn = (a)->{
            System.out.println(a);
//            System.out.println(size);// error, 捕获变量的时候要么是常量, 要么未发生改变过!
        };
        oneParameterNoReturn.test(10);
        // 简写后
        OneParameterNoReturn oneParameterNoReturn2 = a -> System.out.println(a);
        oneParameterNoReturn2.test(10);


//        MoreParameterNoReturn moreParameterNoReturn = (int a, int b) -> {
//            System.out.println(a + b);
//        };
        // 简写后
        MoreParameterNoReturn moreParameterNoReturn = (a, b) -> System.out.println(a + b);
        moreParameterNoReturn.test(10, 20);
    }

    public static void main1(String[] args) {
        // 在没有lambda表达式的时候, 以前是这样写的
//        new NoParameterNoReturn(){
//            @Override
//            public void test() {
//                System.out.println("重写方法！");
//            }
//        }.test();

        // 有lambda表达式的时候, 现在是这样写的
        NoParameterNoReturn parameterNoReturn = () -> System.out.println("重写方法！");
        parameterNoReturn.test();
    }
}