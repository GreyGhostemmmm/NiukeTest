package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/31 15:37
 */

public class Test80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int len = nums.length;
        int count = 0;
        int cur = nums[0];
        int length = nums.length;
        for (int i = 0; i < len; i++) {
            if (cur == nums[i]) {
                count++;
                if (count > 2) {
                    int begin = i;
                    int end = begin;
                    while (end < len && cur == nums[end]) {
                        end++;
                    }
                    int temp = begin;
                    for (int j = end; j < len; j++) {
                        nums[temp++] = nums[j];
                    }
                    len = len - (end - begin);
                    i--;
                }
            } else {
                cur = nums[i];
                count = 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2,2,3,3,3};
        Test80 test80 = new Test80();
        System.out.println(test80.removeDuplicates(nums));
    }
}
