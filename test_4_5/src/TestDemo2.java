/**
 * 利用 synchronized加锁解决 多个线程对同一个变量进行修改操作
 */
class Counter {
    // 这个 变量 就是两个线程要去自增的变量
    volatile public int count;

    // java中解决线程安全的典型手段就是 加锁
    /*synchronized public void increase() { // 这里加锁之后就是1_0000，不加就是5000和1_之间
        count++;
    }*/

    // 这样写是java特有的写法，写法简单，理解难
    public void increase() {
        synchronized (this) {
            count++;
        }
    }
}

public class TestDemo2 {
    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        // 必须要在 t1 和 t2 都执行完了之后, 在打印 count 的结果.
        // 否则, main 和 t1 t2 之间都是并发的关系~~, 导致 t1 和 t2 还没执行完, 就先执行了下面的 打印 操作
        t1.join();
        t2.join();

        // 在 main 中打印一下两个线程自增完成之后, 得到的 count 结果~~
        System.out.println(counter.count);
    }
}

