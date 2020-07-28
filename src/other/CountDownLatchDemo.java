package other;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @date 2020/7/21 9:08
 */

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },"Thread"+i).start();
        }
        try {
            countDownLatch.await();
            System.out.println("nice!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
