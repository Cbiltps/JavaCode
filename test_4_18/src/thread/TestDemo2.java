package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 实现一个简单的线程池
 */
class MyThreadPool {
    // 1. 描述一个任务. 直接使用 Runnable, 不需要额外创建类了.
    // 2. 使用一个数据结构来组织若干个任务.
    private BlockingQueue<Runnable> blockingQueue= new LinkedBlockingQueue<>();
    // 3. 描述一个线程, 工作线程的功能就是从任务队列中取任务并执行.
    static class Worker extends Thread {
        // 当前线程池中有若干个Worker线程~~ 这些线程内部都持有了上述的任务队列.
        private BlockingQueue<Runnable> blockingQueue = null;// 此变量就是方便下面构造便于获取队列的任务（take）

        public Worker(BlockingQueue<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            // 拿到上面的队列
            while (true) {
                try {
                    // 循环获取队列的任务 队列为空就阻塞
                    Runnable runnable = blockingQueue.take();
                    // 获取之后 执行
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 4. 创建一个数据结构组织若干个线程.
    private List<Thread> workers = new ArrayList<>();
    // 在构造方法中创建若干个线程，放在上述的数组中
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(blockingQueue);
            worker.start();
            workers.add(worker);
        }
    }

    // 5. 创建一个方法，允许放任务到线程池中
    public void submit(Runnable runnable) {
        try {
            blockingQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0; i < 100; i++) {
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello Threadpool!");
                }
            });
        }
    }
}
