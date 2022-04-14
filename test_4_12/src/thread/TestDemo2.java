package thread;

/**
 * 自己来实现一个阻塞队列~~先实现一个普通的队列再加上线程安全最后再加上阻塞！
 */
class MyBlockingQueue {
    private int[] arrayBlockingQueue = new int[1000];// 队列的本体
    private int size = 0;// 有效元素个数
    private int head = 0;// 对首下标
    private int tail = 0;// 对尾下标

    private Object locker = new Object();// 专门的锁对象

    /**
     * 放入一个元素
     * @param value
     * @throws InterruptedException
     */
    public void put(int value) throws InterruptedException {
        synchronized (locker) {
            // 如果队列满了直接返回
            if (size == arrayBlockingQueue.length) {
//                return;
                //添加阻塞效果
                locker.wait();
            }
            // 队列没有满就直接放在size的位置上
            arrayBlockingQueue[tail] = value;
            tail++;// 尾位置++
            // 实现了循环队列 如果超过数组的长度就回到0下标重新开始
            if (tail >= arrayBlockingQueue.length) {
                tail = 0;
            }
            // 上面的代码还有其他的写法 如下 但是不够实用 有可读性差等原因
//        tail = tail % arrayBlockingQueue.length;
            size++;// 插入之后修改元素个数
            locker.notify();// 如果入队列成功, 则队列非空, 于是就唤醒 take 中的阻塞等待.
        }
    }

    /**
     * 取出一个元素
     * @return
     * @throws InterruptedException
     */
    public Integer take() throws InterruptedException {
        synchronized (locker) {
            // 如果队列为空返回一个非法值
//            return null;
            if (size == 0) {
                locker.wait();
            }
            // 取出对头的元素
            int headData = arrayBlockingQueue[head];
            head++;// 头位置++
            // 实现了循环队列 如果超过数组的长度就回到0下标重新开始
            if (head >= arrayBlockingQueue.length) {
                head = 0;
            }
            size--;// 取出之后修改元素个数
            locker.notify();// take 成功之后, 就唤醒 put 中的等待.
            return headData;
        }
    }
}

public class TestDemo2 {

    private static MyBlockingQueue myBlockingQueue = new MyBlockingQueue();

    public static void main(String[] args) {
        /**
         * 实现一个简单的阻塞队列 并用它实现生产者消费者模型
         * 下面的代码是 生产者线程
         */
        Thread producer = new Thread(() -> {
            int num = 0;
            while (true) {
                try {
                    myBlockingQueue.put(num);
                    System.out.println("生产了：" + num);
                    num++;
                    // 当生产者生产的慢一些的时候, 消费者就得跟着生产者的步伐走.
//                    Thread.sleep(500);// 达到的效果：队列为空的时候就阻塞，直到put一个元素
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        /**
         * 消费者线程
         */
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int takeNum = myBlockingQueue.take();
                    System.out.println("消费了：" + takeNum);
                    Thread.sleep(500);// 达到的效果：队列为满的时候就阻塞，直到take一个元素
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();
    }

//    public static void main(String[] args) throws InterruptedException {
//        // 简单验证看这个队列是否能正确工作.
//        MyBlockingQueue queue = new MyBlockingQueue();
//        queue.put(1);
//        queue.put(2);
//        queue.put(3);
//        queue.put(4);
//        int ret = 0;
//        ret = queue.take();
//        System.out.println(ret);
//        ret = queue.take();
//        System.out.println(ret);
//        ret = queue.take();
//        System.out.println(ret);
//        ret = queue.take();
//        System.out.println(ret);
//    }

}
