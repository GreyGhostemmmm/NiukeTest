package other;

/**
 * @author Administrator
 * @date 2020/3/9 10:53
 */

public class Base {
    /*private String baseName = "base";
    public other.Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends other.Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        other.Base b = new Sub();
    }*/

    private String name = "qq";
    public Base(String s){
        System.out.print("B");
    }
}
class Derived extends Base{
    public Derived (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        Base base = new Derived("C");
        //System.out.println(base.name);
    }
}
