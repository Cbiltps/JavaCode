package thread;

/**
 * 匿名内部类实现 和TestDemo3类似
 */
public class TestDemo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        });
        thread.start();
    }
}
