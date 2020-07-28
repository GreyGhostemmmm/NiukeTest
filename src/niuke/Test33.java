package niuke;

/**
 * @author Administrator
 * @date 2020/2/25 10:46
 */

public class Test33 {
    public int GetUglyNumber_Solution(int index) {
        if(index == 1)
            return 1;
        int num = 2;
        int i = 1;
        int result = 0;
        while(i < index){
            if(num%7 == 0){
                num++;
                continue;
            }
            if((num%2 == 0)||(num%3 == 0)||(num%5 == 0)){
                result = num;
                i++;
            }
            num++;
        }
        return result;
    }

    public static void main(String[] args) {
        Test33 test33 = new Test33();
        System.out.println(test33.GetUglyNumber_Solution(1500));
    }
}
