package thread;

// Runnable 就是在描述一个"任务"
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}

/**
 *
 */
public class TestDemo3 {
    public static void main(String[] args) {
        Thread thread3 = new Thread(new MyRunnable());
        thread3.start();
    }
}