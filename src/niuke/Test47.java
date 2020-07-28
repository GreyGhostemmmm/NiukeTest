package niuke;

/**
 * @author Administrator
 * @date 2020/3/18 21:07
 */

public class Test47 {
    static int Sum_Solution(int n) {
        /*int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;*/

        int result = 0;
        int a = 1;
        boolean value = ((n!=0) && a == (result = Sum_Solution(n-1)));
        result += n;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Test47.Sum_Solution(3));
    }
}
