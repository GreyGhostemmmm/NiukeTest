package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/30 16:10
 */

public class LTest08_11 {
    public int waysToChange(int n) {
        int[] coin = new int[]{1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];
        for (int i = 1; i < 5; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coin[i-1] < 0){                   // 要组成的面值比当前硬币金额小，该硬币不可以选择
                    dp[i][j] = dp[i - 1][j] % 1000000007;  // 只能由 i - 1 中硬币来组成面值 j
                } else {
                    // 当前硬币可以不选，也可以选择
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coin[i-1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static void main(String[] args) {
        LTest08_11 ltest = new LTest08_11();
        System.out.println(ltest.waysToChange(10));
    }
}
