package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable是一个interface. 相当于把线程封装了一个 "返回值". 方便程序猿借助多线程的方式计算结果.
 */
public class TestDemo {
    public static void main(String[] args) {
        // 通过 callable 来描述一个这样的任务~~
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 为了让线程执行 callable 中的任务, 光使用构造方法还不够, 还需要一个辅助的类.
        FutureTask<Integer> task = new FutureTask<>(callable);
        // 创建线程, 来完成这里的计算工作~~
        Thread t = new Thread(task);
        t.start();

        // 凭小票来端你自己的麻辣烫.
        // 如果线程的任务没有执行完呢, get 就会阻塞.
        // 一直阻塞到, 任务完成了, 结果算出来了~~
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
