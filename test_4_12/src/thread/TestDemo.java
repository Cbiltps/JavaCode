package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 基于这个内置的阻塞队列，实现一个简单的生产者消费者模型，阻塞队列是生产者消费者模型的交易场所
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        /*注意：上面抛出的异常就是因为下面的put操作可能触发阻塞，阻塞就需要打断，打断就需要唤醒，因此就会抛异常！*/
        BlockingQueue<String> blockingQueue =  new LinkedBlockingDeque<>();
        blockingQueue.put("hello");
        String takeString = blockingQueue.take();
    }
}
