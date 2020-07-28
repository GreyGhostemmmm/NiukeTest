package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/20 20:10
 */

public class Test674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2){
            return 1;
        }
        int max = 1;
        int index = 0;
        int count = 1;
        while(index < nums.length - 1){
            if(nums[index] < nums[index+1]){
                count++;
                index++;
            }
            else{
                if(count > max){
                    max = count;
                }
                count = 1;
                index = index + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        Test674 test674 = new Test674();
        System.out.println(test674.findLengthOfLCIS(nums));
    }
}
