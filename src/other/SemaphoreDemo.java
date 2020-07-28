package other;

import java.util.concurrent.Semaphore;

/**
 * @author Administrator
 * @date 2020/7/21 8:55
 */

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "Thread" + i).start();
        }
    }
}
