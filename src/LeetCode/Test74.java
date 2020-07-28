package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/13 16:31
 */

public class Test74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(target < matrix[0][0]){
            return false;
        }
        if(target > matrix[rows-1][cols-1]){
            return false;
        }
        boolean flag = false;
        int rowStart = 0;
        int rowEnd = rows;
        while (rowStart < rowEnd) {
            int mid = (rowStart + rowEnd) / 2;
            if (matrix[mid][0] > target) {
                rowEnd = mid;
            } else if (matrix[mid][0] < target) {
                rowStart = mid + 1;
            } else {
                flag = true;
                return flag;
            }
        }
        int colStart = 0;
        int colEnd = cols;
        while (colStart < colEnd) {
            int mid = (colStart + colEnd) / 2;
            if (matrix[rowEnd-1][mid] > target) {
                colEnd = mid;
            } else if (matrix[rowEnd-1][mid] < target) {
                colStart = mid + 1;
            } else {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        Test74 test74 = new Test74();
        System.out.println(test74.searchMatrix(matrix,20));
    }
}
