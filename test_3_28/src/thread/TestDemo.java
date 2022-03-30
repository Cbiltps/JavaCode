package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Thread!");
    }
}

/**
 * 最基本的创建线程的方法
 */
public class TestDemo {
    public static void main(String[] args) {
        // 如果想要支持多任务就要并发编程（注意这里包含的是并行加并发）！
        Thread thread = new MyThread();
        thread.start();
    }
}