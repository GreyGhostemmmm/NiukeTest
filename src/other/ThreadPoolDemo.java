package other;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @date 2020/7/21 9:16
 */

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 15; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t come in!");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
