package niuke;

/**
 * @author Administrator
 * @date 2020/3/2 16:49
 */

public class TestStaticCon {
    /*public static int a = 0;
    static {
        a = 10;
        System.out.println("父类的静态代码块在执行a=" + a);
    }
    {
        a = 8;
        System.out.println("父类的非静态代码块在执行a=" + a);
    }
    public niuke.TestStaticCon() {

        //this("a在父类带参构造方法中的值：" + niuke.TestStaticCon.a); // 调用另外一个构造方法
        System.out.println(a);
        System.out.println("父类无参构造方法在执行a=" + a);
    }
    public niuke.TestStaticCon(String n) {
        System.out.println(n);
        System.out.println(a);
    }
    public static void main(String[] args) {
        niuke.TestStaticCon tsc = null;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        tsc = new niuke.TestStaticCon();
    }*/

    public static int k = 0;
    public static TestStaticCon t1 = new TestStaticCon("t1");
    public static TestStaticCon t2 = new TestStaticCon("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");
    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public TestStaticCon(String str){
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++i;++n;
    }

    public static int print(String str){
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestStaticCon t = new TestStaticCon("init");
    }
}
