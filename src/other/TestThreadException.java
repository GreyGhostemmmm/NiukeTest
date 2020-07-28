package other;

/**
 * @author Administrator
 * @date 2020/7/21 10:43
 */

public class TestThreadException extends Thread{

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            new TestThreadException().start();
        } catch (RuntimeException ex) {
            System.out.println("thread");
            //   看看能不能到达这里？   :)
        }

        Thread.sleep(1000);
        System.out.println("main");
        //   看看能不能到达这里？   :)
    }

}
