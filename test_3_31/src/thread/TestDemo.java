package thread;

/**
 * 通过让一变量自增多次体现单线程和多线程的效率
 */
public class TestDemo {
    private static final long count = 10_0000_0000L;

    /**
     * 串行执行
     */
    public static void serial() {
        long beg = System.currentTimeMillis();// 开始时间
        long a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }

        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();// 结束时间
        System.out.println("消耗时间: " + (end - beg) + "ms");// 记录程序执行时间
    }


    /**
     * 并发执行 有一点要注意：任务量大的时候，多线程的优势才会体现出来！
     * @throws InterruptedException
     */
    public static void concurrency() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < count; i++) {
                a++;
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < count; i++) {
                b++;
            }
        });
        t2.start();

        /*此处不能直接这么记录结束时间.
        别忘了, 现在这个求时间戳的代码是在 main 线程中.
        main 和 t1 t2 之间是并发执行的关系, 此处 t1 和 t2 还没执行完呢, 这里就开始记录结束时间了, 这显然是不准确的.
        正确做法应该是让 main 线程等待 t1 和 t2 跑完了, 再来记录结束时间. */

        t1.join();// join 效果就是等待线程结束------t1.join 就是让 main 线程等待 t1 结束.
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("消耗时间: " + (end - beg) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        //serial();
        concurrency();
    }
}