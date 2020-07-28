package other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @date 2020/6/25 20:32
 */
class MyResource {
    private volatile boolean flag = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockQueue = null;

    public MyResource(BlockingQueue<String> blockQueue) {
        this.blockQueue = blockQueue;
        System.out.println(blockQueue.getClass().getName());
    }

    public void prod() throws Exception {
        String data = null;
        boolean retValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockQueue.offer(data, 2, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t" + "插入" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + "插入" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "生产结束");
    }

    public void consume() throws Exception {
        String result = null;
        while (flag) {
            result = blockQueue.poll(2, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "消费结束");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "取出" + result + "成功");
        }
    }

    public void stop() throws Exception {
        flag = false;
    }
}


public class BlockQueue {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new SynchronousQueue<String>(true));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "生产开始");
            try {
                myResource.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "消费开始");
            try {
                myResource.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consume").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("午时已到");
        myResource.stop();
    }
}
