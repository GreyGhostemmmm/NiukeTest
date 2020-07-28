package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/1 17:28
 */

public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int k = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while(count < row * col){
            for(j = k; j < col - k; j++){
                list.add(matrix[i][j]);
                count++;
            }
            if(count == row * col){
                break;
            }
            j--;
            i++;
            for(; i < row - k; i++){
                list.add(matrix[i][j]);
                count++;
            }
            if(count == row * col){
                break;
            }
            i--;
            j--;
            for(; j > k - 1; j--){
                list.add(matrix[i][j]);
                count++;
            }
            if(count == row * col){
                break;
            }
            j++;
            i--;
            for(; i > k; i--){
                list.add(matrix[i][j]);
                count++;
            }
            i++;
            j++;
            k++;
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Test54 test54 = new Test54();
        List<Integer> list = test54.spiralOrder(nums);
        System.out.println(list);
        /*List<int[]> list1 = new ArrayList<>();
        int[] c = new int[2];
        list1.add(new int[]{1,2});
        list1.toArray(new int[0][]);*/
        Arrays.sort(nums,(a,b)->a[0] - b[0]);
    }
}
