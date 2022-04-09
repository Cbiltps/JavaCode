import java.util.Scanner;

/**
 * 因为 内存可见性（因为编译器优化所导致的） 出现的一个 线程安全的问题 以及问题的解决！
 * 因为t线程感知不到内存发生的变化！
 */
public class TestDemo3 {
    private static int isQuit = 0;
//    private static volatile int isQuit = 0;// 这样也是可以的，但是每次都是向内存读取


    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            /*在下面的循环里面什么都不写的时候，输入1的时候，循环是不退出的！
            * 编译器优化这个事情比较玄学，不知道啥时候优化，啥时候不优化！*/
            while (isQuit == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("循环结束! t 线程退出!");
        });
        t.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个 isQuit 的值: ");
        isQuit = scanner.nextInt();
        System.out.println("main 线程执行完毕!");
    }
}
