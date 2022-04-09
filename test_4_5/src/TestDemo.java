 /*状态是PCB上的一个属性！
  * 在Java里面，尤其是Thread类里面，对于线程的状态有了进一步的细化！*/

public class TestDemo {
    /**
     * 获取指定线程的状态 NEW状态
     * @param args
     */
/*    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
        System.out.println(thread.getState());
        thread.start();
    }*/

    /**
     * 获取指定线程的状态 TERMINATED状态
     * @param args
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }*/

    /**
     * 获取指定线程的状态 RUNNABLE状态
     * @param args
     * @throws InterruptedException
     */
    /*public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 这里啥都不能有，处于一个快速循环的状态！
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }*/

    /**
     * 获取指定线程的状态 TIMED_WAITING状态
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    /*还有两个状态 等待锁 和 等待唤醒，后面的时候演示！*/
}
