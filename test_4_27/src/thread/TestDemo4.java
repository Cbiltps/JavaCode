package thread;

import java.util.concurrent.CountDownLatch;

/**
 * 调用countDown的次数和执行次数一致时，此时的await就会直接返回
 */
public class TestDemo4 {
    public static void main(String[] args) throws InterruptedException {
        // 构造方法的参数表示有几个选手参赛.
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "到达终点！");
                countDownLatch.countDown();
            });
            thread.start();
        }

        // 裁判就要等待所有的线程到达
        // 当这些线程没有执行完的时候, await就阻塞, 所有的线程都执行完了, await才返回.
        countDownLatch.await();
        System.out.println("比赛结束！");
    }
}
