package thread;

/**
 * 给线程命名 方便jconsole工具调试观察线程名
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("hello thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("hello thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread t2");
        t2.start();
    }
}
