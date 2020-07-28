package InnerClass;

/**
 * @author Administrator
 * @date 2020/2/15 20:52
 */

public class Goods {
    private class Content implements Contents {
        private int i = 11;
        public int value() {
        return i;
        }
    }

    protected class GDestination implements Destination {
        private String label;
        private GDestination(String whereTo) {
        label = whereTo;
    }
    public String readLabel() {
        return label;
    }
}

    public Destination dest(String s) {
        return new GDestination(s);
    }

    public Contents cont() {
        return new Content();
 }

    public static void main(String[] args) {
        Goods p = new Goods();
        Contents c = p.cont();
        Destination d = p.dest("Beijing");
    }
}


