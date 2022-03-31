package thread;

/**
 * 使用 lambda表达式 相当于是TestDemo5的延伸
 */
public class TestDemo6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Hello Thread!");
        });
        thread.start();
    }
}
