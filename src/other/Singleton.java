package other;

/**
 * @author Administrator
 * @date 2020/7/14 22:14
 */

public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton(){

    }

    public static Singleton getSingleton(Singleton singleton){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
