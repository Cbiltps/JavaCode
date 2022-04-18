package thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 创建一个类表示当前任务(描述任务)
 * 1：任务的具体内容
 * 2：任务的具体时间
 *
 * 注意：定时器是一个日常开发的一个组件，非常的重要！
 */
class MyTask implements Comparable<MyTask> {
    private Runnable runnable;// 任务具体要干啥
    private long time;// 保存任务执行的毫秒级时间戳————任务具体啥时候干

    // after是一个时间间隔————不是绝对的时间戳的值
    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public long getTime() {
        return time;
    }

    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time - o.time);
    }
}

/**
 * 定时器内部要存放多个任务
 */
class MyTimer {
    PriorityBlockingQueue<MyTask> priorityBlockingQueue = new PriorityBlockingQueue<>();

    private Object locker = new Object();// 指定一个成员变量 方便所对象使用

    public void schedule(Runnable runnable, long delay) {
        MyTask myTask = new MyTask(runnable, delay);
        priorityBlockingQueue.put(myTask);
        // 每次任务插入成功之后, 都唤醒一下扫描线程, 让线程重新检查一下队首的任务看是否时间到要执行~~
        synchronized (locker) {
            locker.notify();
        }
    }

    public MyTimer() {
        Thread threadMyTimer = new Thread(() -> {
           while (true) {
               try {
                   MyTask headTask = priorityBlockingQueue.take();// 取出队首元素
                   long curTime = System.currentTimeMillis();
                   if (curTime < (headTask).getTime()) {
                       // 时间没到，把任务put回队列
                       priorityBlockingQueue.put(headTask);
                       // 指定一个等待时间
                       synchronized (locker) {
                           locker.wait(headTask.getTime() - curTime);// 时间到了之后自动被唤醒
                       }
                   } else {
                       // 时间到了，执行任务
                       headTask.run();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        threadMyTimer.start();
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello timer!");
            }
        }, 3000);
        System.out.println("main");
    }
}
