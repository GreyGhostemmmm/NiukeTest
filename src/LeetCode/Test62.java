package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/3 16:25
 */

public class Test62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            dp[i][1] = 1;
        }
        for(int i = 1; i < n + 1; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i < m + 1; i++){
            for(int j = 2; j < n + 1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Test62 test62 = new Test62();
        System.out.println(test62.uniquePaths(3, 2));
    }
}
