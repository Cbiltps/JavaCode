package thread;

/**
 * 获取线程实例
 */
public class TestDemo7 {
    public static void main(String[] args) {

//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                // System.out.println(Thread.currentThread().getName());
//                System.out.println(this.getName());
//            }
//        };
//        t.start();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println(this.getName()); error Runnable 没有name属性！
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();

        // 这个操作是在 main 线程中调用的. 因此拿到的就是 main 这个线程的实例
        System.out.println(Thread.currentThread().getName());
    }
}
