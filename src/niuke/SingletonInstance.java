package niuke;

/**
 * 单例模式
 * @author Administrator
 * @date 2020/3/16 22:53
 */

public class SingletonInstance {

    //懒汉式
    private static volatile SingletonInstance singletonInstance = null;

    private SingletonInstance(){

    }

    public static synchronized SingletonInstance getSingletonInstance() {
        if(singletonInstance == null){
            singletonInstance = new SingletonInstance();
        }
        return singletonInstance;
    }
}
