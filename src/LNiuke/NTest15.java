package LNiuke;

/**
 *
 *
 *@author Administrator
 *@date 2020/7/28 21:16
 */

public class NTest15 {
    public int hammingWeight(int n) {
        int count = 0;
        int num = n;
        while(num != 0){
            count += (num & 1);
            num = num >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        NTest15 nTest15 = new NTest15();
        System.out.println(nTest15.hammingWeight(n));
    }
}
