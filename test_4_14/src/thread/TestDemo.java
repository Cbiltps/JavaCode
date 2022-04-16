package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 标准库的定时器用法
 */
public class TestDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer!");
            }
        }, 3000);
        System.out.println("main");
    }
}
