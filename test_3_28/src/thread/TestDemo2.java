package thread;

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello Thread!");
            try {
                Thread.sleep(1000);// 强制让线程进入阻塞状态（休眠一段时间）
            } catch (InterruptedException e) { // 受查异常 表示线程被强制中断了
                e.printStackTrace();
            }
        }
    }
}

/**
 * 以下代码更能体现 并发关系
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Thread thread2 = new MyThread2();
        thread2.start();

        // 自动创建的 main线程 与 手动创建的线程 有并发关系
        while (true) {
            System.out.println("Hello Main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
