package LNiuke;

/**
 * @author Administrator
 * @date 2020/7/28 19:54
 *
 */

public class NTest04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4},{2,5}};
        NTest04 nTest04 = new NTest04();
        System.out.println(nTest04.findNumberIn2DArray(matrix, 2));
    }
}
