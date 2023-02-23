import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Cbiltps
 * Date: 2023-02-23
 * Time: 22:56
 */
class Test {
    public void test() {
        System.out.println("test()");
    }
}

public class AnonymousInner {
    public static void main(String[] args) {
        new Test(){
            @Override
            public void test() {
                System.out.println("我是重写的test方法!");
            }
        }.test();

        /**
         * 之前写PriorityQueue的时候就是用的匿名内部类, 表示某个类实现了Comparator接口, 并重写了compare方法
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}