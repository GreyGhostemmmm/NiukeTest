package niuke; /**
 * @author Administrator
 * @date 2020/3/16 21:43
 */
import java.util.ArrayList;
public class Test41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 1;
        int count = 0;
        while(i < sum){
            count = 0;
            for(int j = i;j < sum;j++){
                count = count + j;
                if(count > sum){
                    break;
                }
                if(count == sum){
                    ArrayList<Integer> number = new ArrayList<>();
                    for(int temp = i; temp <= j; temp++){

                        number.add(temp);
                    }
                    result.add(number);
                    break;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Test41 test41 = new Test41();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = test41.FindContinuousSequence(9);
        System.out.println(result);
    }
}
