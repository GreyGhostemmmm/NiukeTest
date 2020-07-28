package LNiuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/10 20:32
 */

public class NTest49 {
    public int nthUglyNumber(int n) {
        if (n <= 3) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        int num = 6;
        n = n - 3;
        while (true) {
            for (int i = list.size() - 1; i >= 0; i--) {
                int temp = list.get(i);
                int res = num / temp;
                int other = num % temp;
                if (other == 0 && list.contains(res)) {
                    list.add(num);
                    n--;
                    break;
                }
            }
            if (n == 0) {
                break;
            }
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        NTest49 nTest49 = new NTest49();
        System.out.println(nTest49.nthUglyNumber(10));
    }
}
