package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入互斥锁. 和synchronized定位类似, 都是用来实现互斥效果, 保证线程安全.
 */
public class TestDemo2 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        // 加锁
        locker.lock();
        // 抛出异常了. 就容易导致unlock执行不到~~
        // 解锁
        locker.unlock();
    }
}
