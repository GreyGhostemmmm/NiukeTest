package sort;

import other.InnerClassTest;

/**
 * @author Administrator
 * @date 2020/8/2 23:05
 */

public class OtherPackage {
    InnerClassTest innerClassTest = new InnerClassTest();
    InnerClassTest.PublicInnerClass publicIn = innerClassTest.new PublicInnerClass();
}
