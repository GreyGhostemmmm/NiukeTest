package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/20 16:55
 */

public class Test174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = dungeon[rows - 1][cols - 1] < 0 ? -dungeon[rows - 1][cols - 1] + 1 : 1;
        for (int i = rows - 2; i >= 0; i--) {
            if (dp[i + 1][cols - 1] - dungeon[i][cols - 1] <= 0) {
                dp[i][cols - 1] = 1;
            } else {
                dp[i][cols - 1] = dp[i + 1][cols - 1] - dungeon[i][cols - 1];
            }
        }
        for (int i = cols - 2; i >= 0; i--) {
            if (dp[rows - 1][i + 1] - dungeon[rows - 1][i] <= 0) {
                dp[rows - 1][i] = 1;
            } else {
                dp[rows - 1][i] = dp[rows - 1][i + 1] - dungeon[rows - 1][i];
            }
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int before = Math.min(dp[i + 1][j], dp[i][j + 1]);
                if (before - dungeon[i][j] <= 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = before - dungeon[i][j];
                }
            }
        }
        return dp[0][0] > 0 ? dp[0][0] : 1;
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{1,-2,3},{2,-2,-2}};
        Test174 test174 = new Test174();
        System.out.println(test174.calculateMinimumHP(num));
    }
}
