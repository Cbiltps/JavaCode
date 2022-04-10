package thread;

/**
 * 调用wait方法的线程，会使这个线程进入阻塞状态
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait 前");
            object.wait();
            System.out.println("wait 后");
        }
    }
}
