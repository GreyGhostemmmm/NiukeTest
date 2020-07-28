package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/3 20:00
 */

public class Test64 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            dp[i][0] = sum + grid[i][0];
            sum += grid[i][0];
        }
        sum = 0;
        for (int i = 0; i < cols; i++) {
            dp[0][i] = sum + grid[0][i];
            sum += grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int temp = dp[i - 1][j] > dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j];
                dp[i][j] = temp + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Test64 test64 = new Test64();
        System.out.println(test64.minPathSum(nums));
    }
}
