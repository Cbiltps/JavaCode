package thread;

/**
 * 匿名内部类实现 和TestDemo类似
 */
public class TestDemo4 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello Thread");
            }
        };
        thread.start();
    }
}
