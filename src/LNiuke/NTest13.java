package LNiuke;

import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2020/7/13 19:40
 */

public class NTest13 {
    public int movingCount(int m, int n, int k) {
        LinkedList<int[][]> queue = new LinkedList<>();
        boolean[][] flag = new boolean[m][n];
        int[][] cur = new int[1][2];
        queue.add(cur);
        int count = 0;
        while (!queue.isEmpty()) {
            int[][] temp = queue.poll();
            if (flag[temp[0][0]][temp[0][1]]) {
                continue;
            }
            flag[temp[0][0]][temp[0][1]] = true;
            count++;
            if(temp[0][0] + 1 < m){
                int up = countSum(temp[0][0] + 1) + countSum(temp[0][1]);
                if (up <= k) {
                    int[][] res = new int[1][2];
                    res[0][0] = temp[0][0] + 1;
                    res[0][1] = temp[0][1];
                    queue.add(res);
                }
            }
            if(temp[0][1] + 1 < n){
                int right = countSum(temp[0][0]) + countSum(temp[0][1] + 1);
                if (right <= k) {
                    int[][] res = new int[1][2];
                    res[0][0] = temp[0][0];
                    res[0][1] = temp[0][1] + 1;
                    queue.add(res);
                }
            }

        }
        return count;
    }

    int countSum(int n) {
        int sum = 0;
        int num = n;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        NTest13 nTest13 = new NTest13();
        System.out.println(nTest13.movingCount(3, 1, 0));
    }
}
