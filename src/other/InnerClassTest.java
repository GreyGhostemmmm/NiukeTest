package other;

/**
 * @author Administrator
 * @date 2020/8/2 22:55
 */

public class InnerClassTest {

    private class PrivateInnerClass {
        private void private_method() {
        }

        ;

        void default_method() {
        }

        ;

        protected void protected_method() {
        }

        ;

        public void public_method() {
        }

        ;
    }

    class DefaultInnerClass {
        private void private_method() {
        }

        ;

        void default_method() {
        }

        ;

        protected void protected_method() {
        }

        ;

        public void public_method() {
        }

        ;
    }

    protected class ProtectedInnerClass {
        private void private_method() {
        }

        ;

        void default_method() {
        }

        ;

        protected void protected_method() {
        }

        ;

        public void public_method() {
        }

        ;
    }

    public class PublicInnerClass {
        private void private_method() {
        }

        ;

        void default_method() {
        }

        ;

        protected void protected_method() {
        }

        ;

        public void public_method() {
        }

        ;
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        PrivateInnerClass privateIn = innerClassTest.new PrivateInnerClass();
        privateIn.private_method();
    }
}
