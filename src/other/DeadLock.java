package other;

import sun.misc.Lock;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2020/7/1 9:01
 */
class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t" + "get" + "\t" + lockA);
            System.out.println(Thread.currentThread().getName() + "\t" + "try" + "\t" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t" + "get" + "\t" + lockB);
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "LockB";

        new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }

}
