package thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 创建一个类表示当前任务(描述任务)
 * 1：任务的具体内容
 * 2：任务的具体时间
 */
class MyTask {
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
}

/**
 * 定时器内部要存放多个任务
 */
class MyTimer {
    PriorityBlockingQueue<MyTask> priorityBlockingQueue = new PriorityBlockingQueue<>();

    public void schedule(Runnable runnable, long delay) {
        MyTask myTask = new MyTask(runnable, delay);
        priorityBlockingQueue.put(myTask);
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

    }
}
