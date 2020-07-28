package niuke;

/**
 * @author Administrator
 * @date 2020/3/18 17:26
 */

public class Test45 {
    static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        int temp = 0;
        int count = 0;
        for(int i = 0;i < numbers.length;i++){
            if(numbers[i] == 0)
                count++;
            if(count == 4)
                return true;
            for(int j = i + 1;j < numbers.length;j++){
                if(numbers[j] < numbers[i]){
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        int sum = 0;
        for(int i = count;i < numbers.length - 1;i++){
            sum = sum + numbers[i+1] - numbers[i];
        }
        if(sum <= 4)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,3,0,5,0};
        System.out.println(Test45.isContinuous(num));
    }
}
