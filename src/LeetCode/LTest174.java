package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/12 16:02
 */

public class LTest174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        int[][] summary = new int[rows][cols];
        dp[0][0] = dungeon[0][0];
        summary[0][0] = dungeon[0][0];
        int sum = dungeon[0][0];
        for (int i = 1; i < cols; i++) {
            sum = sum + dungeon[0][i];
            summary[0][i] = sum;
            if (dungeon[0][i] >= 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                if (sum < dp[0][i - 1]) {
                    dp[0][i] = sum;
                } else {
                    dp[0][i] = dp[0][i - 1];
                }
            }
        }
        sum = dungeon[0][0];
        for (int i = 1; i < rows; i++) {
            sum = sum + dungeon[i][0];
            summary[i][0] = sum;
            if (dungeon[i][0] >= 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                if (sum < dp[i - 1][0]) {
                    dp[i][0] = sum;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                summary[i][j] = Math.max(summary[i - 1][j], summary[i][j - 1]) + dungeon[i][j];
                if (dungeon[i][j] < 0) {
                    if (summary[i][j] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[rows - 1][cols - 1] < 0 ? -dp[rows - 1][cols - 1] : 0;
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        LTest174 lTest174 = new LTest174();
        System.out.println(lTest174.calculateMinimumHP(dungeon));
    }
}
