package thread;

/**
 * 通过线程等待干预了两个线程的执行顺序
 * 注意：这个代码好像有问题。。。到时候问一下老司！
 */
public class TestDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        // 在主线程中就可以使用一个等待操作. 来等待 t 线程执行结束.
//        Thread t2 = new Thread(() -> {
//            try {
//                t.join(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t2.start();

        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
