package thread;

/**
 * 调用wait方法的线程，就会陷入阻塞阻，塞到有其他线程通过notify来通知~
 */
public class TestDemo2 {
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 进行 wait
            synchronized (locker) {
                System.out.println("wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait 之后");
            }
        });
        t1.start();

        Thread.sleep(3000);

        Thread t2 = new Thread(() -> {
            // 进行 notify
            synchronized (locker) {
                System.out.println("notify 之前");
                locker.notify();
                System.out.println("notify 之后");
            }
        });
        t2.start();
    }
}
