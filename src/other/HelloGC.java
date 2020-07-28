package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @date 2020/7/1 9:35
 */

public class HelloGC {
    public static void main(String[] args) throws Exception {
        /*System.out.println("HelloGC");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory() / (double) 1024 / 1024);   //jvm使用最大内存量
        System.out.println(Runtime.getRuntime().totalMemory() / (double) 1024 / 1024); //jvm内存总量*/
        byte[] bytes = new byte[1024*1024*80];
        /*List<String> list = new ArrayList<>();
        int i = 0;

        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("i="+i);
            e.printStackTrace();
            throw e; 
        }*/

    }
}
