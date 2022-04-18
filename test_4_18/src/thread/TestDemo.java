package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java标准库中线程池的使用
 */
public class TestDemo {
    public static void main(String[] args) {
        // 创建一个固定线程数的线程池 参数指定了线程个数
        ExecutorService pool = Executors.newFixedThreadPool(10);// 这个用的比较多

        // 创建一个自动扩容的线程池 会根据任务量来自动进行扩容
        // Executors.newCachedThreadPool();

        // 创建只有一个线程的线程池
        // Executors.newSingleThreadExecutor();

        // 创建一个带有定时器功能的线程池，类似于Timer
        // Executors.newScheduledThreadPool();

        for (int i  = 0; i <= 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello threadPool!");
                }
            });
        }
    }
}
