import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * lambda表达式使用的前提是:
 *     你对其背后 函数式接口的抽象方法 非常熟悉!!!
 *     以后用的地方多的就是打印元素的时候快!
 * User: cbiltps
 * Date: 2023-03-02
 * Time: 09:03
 */
class Test {
    public void func(){
        System.out.println("func()");
    }
}
public class TestDemo2 {

    /**
     * Lambda在集合当中的使用
     * @param args
     */
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "hello");
        map.put(4, "lambda");

        // 重写accept方法
        map.forEach((key, value) -> System.out.println("key:" + key + " value:" + value));

        System.out.println("======================");

        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
                System.out.println("key:" + k + " value:" + v);
            }
        });
    }

    /**
     * Lambda在集合当中的使用
     * @param args
     */
    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("lambda");

        // 未使用lambda表达式
//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        // 重写accept方法
        list.forEach(s -> System.out.println(s));



        // 未使用lambda表达式
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        // 重写compare方法
        list.sort(((o1, o2) -> o1.compareTo(o2)));// 排序

        System.out.println("============");

        list.forEach(s -> System.out.println(s));
    }


    /**
     * 在匿名内部类中是这样, lambda表达式中也是
     * @param args
     */
    public static void main1(String[] args) {
        int a = 100;
        a = 99;
        new Test(){
            @Override
            public void func() {
                System.out.println("我是内部类, 且重写了func这个方法！");
//                System.out.println("捕获变量, 要么是常量, 要么未发生改变过：" + a);// error
            }
        }.func();
    }
}