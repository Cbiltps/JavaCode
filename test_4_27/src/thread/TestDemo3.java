package thread;

import java.util.concurrent.Semaphore;

/**
 * 信号量的理解以及使用
 */
public class TestDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);// 初始化的值代表可用资源有四个

//        semaphore.acquire(2);// 申请资源，p操作
//        semaphore.release(2);// 释放资源，v操作

        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");

        /*可以看到上面的代码打印的结果只有四个，因为可用的资源只有四个，除非再次release资源，否则一直会发生阻塞！*/
    }
}
