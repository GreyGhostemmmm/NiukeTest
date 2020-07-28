package niuke; /**
 * @author Administrator
 * @date 2020/2/18 12:09
 */
import java.util.ArrayList;
public class Test19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int begin_row = 0;
        int begin_column = 0;
        int end_row = row;
        int end_column = column;
        boolean flag = true;
        while((begin_row != end_row) || (begin_column != end_column)){
            if(flag){
                for(int i = begin_column;i < end_column;i++){
                    list.add(matrix[begin_row][i]);
                }
                begin_row++;
                if(begin_row == end_row)
                    break;
                for(int j = begin_row;j < end_row;j++){
                    list.add(matrix[j][end_column-1]);
                }
                end_column--;
                if(begin_column == end_column)
                    break;
                flag = false;
            }
            else{
                for(int i = end_column-1;i >= begin_column;i--){
                    list.add(matrix[end_row-1][i]);
                }
                end_row--;
                if(begin_row == end_row)
                    break;
                for(int j = end_row-1;j >= begin_row;j--){
                    list.add(matrix[j][begin_column]);
                }
                begin_column++;
                if(begin_column == end_column)
                    break;
                flag = true;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int array[][] = {{1,2},{3,4}};
        Test19 test19 = new Test19();
        ArrayList<Integer> list = new ArrayList<>();
        list = test19.printMatrix(array);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
