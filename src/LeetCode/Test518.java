package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/17 14:55
 */

public class Test518 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        for(int i = 0; i <= len; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= amount; j++){
                for(int k = 0; k * coins[i-1] <= j; k++){
                    dp[i][j] += dp[i-1][j - k*coins[i-1]];
                }
            }
        }
        return dp[len][amount];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,5};
        Test518 test518 = new Test518();
        System.out.println(test518.change(5, a));
    }
}
