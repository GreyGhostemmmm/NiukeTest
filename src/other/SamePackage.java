package other;

/**
 * @author Administrator
 * @date 2020/8/2 23:00
 */

public class SamePackage {
    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        InnerClassTest.DefaultInnerClass defaultIn = innerClassTest.new DefaultInnerClass();
        defaultIn.default_method();
    }
}
