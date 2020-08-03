package other;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2020/7/30 11:04
 */

public class ThreadLocalTest {
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,8,5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 5; i++) {
                int j = i;
                poolExecutor.execute(()->{
                    //设置线程中本地变量的值
                    localVar.set("localVar" + j);
                    //调用打印方法
                    print("thread" + j);
                    //打印本地变量
                    System.out.println("after remove : " + localVar.get());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }
}
