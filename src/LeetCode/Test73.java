package LeetCode;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2020/7/13 15:54
 */

public class Test73 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<int[][]> list = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    int[][] temp = new int[1][2];
                    temp[0][0] = i;
                    temp[0][1] = j;
                    list.add(temp);
                }
            }
        }
        for (int len = 0; len < list.size(); len++) {
            int[][] cur = list.get(len);
            int row = cur[0][0];
            int col = cur[0][1];
            for (int i = 0; i < cols; i++) {
                matrix[row][i] = 0;
            }
            for (int j = 0; j < rows; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Test73 test73 = new Test73();
        test73.setZeroes(nums);
        System.out.println(nums);
    }
}
