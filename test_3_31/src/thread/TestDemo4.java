package thread;

/**
 * 设置标志位来控制线程是否执行
 */
public class TestDemo4 {
    private static boolean isQuit = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!isQuit) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        // 只要把这个 isQuit 设为 true, 此时这个循环就退出了, 进一步的 run 就执行完了, 再进一步就是线程执行结束了.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isQuit = true;
        System.out.println("终止 t 线程!");
    }
}
