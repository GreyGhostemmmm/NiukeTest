package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2020/6/26 17:08
 */
class Test {
    private int num;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void myProd() {
        try {
            lock.lock();
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + "produce" + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void myConsume() {
        try {
            lock.lock();
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + "consume" + "\t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class ProdAndConsume {
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                test.myProd();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                test.myConsume();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                test.myConsume();
            }
        }, "CC").start();
    }

}
