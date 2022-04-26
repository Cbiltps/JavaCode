package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于CAS能够实现"原子类"，Java标准库里提供了一组原子类，针对常的一些 int, long, int array...进行了封装，
 * 可以基于CAS的方式进行修改，并且线程安全！
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);// 这样创建变量

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 这个方法就相当于 num++
                num.getAndIncrement();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 这个方法就相当于 num++
                num.getAndIncrement();
            }
        });

//        // ++num
//        num.incrementAndGet();
//        // --num
//        num.decrementAndGet();
//        // num--
//        num.getAndDecrement();
//        // += 10
//        num.getAndAdd(10);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 通过 get 方法得到 原子类 内部的数值.
        System.out.println(num.get());
    }
}
