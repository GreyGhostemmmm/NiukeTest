package LeetCode;

/**
 * @author Administrator
 * @date 2020/6/27 16:06
 */

public class Test55 {

    public boolean result = true;

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2, 5, 0, 0};
        Test55 test55 = new Test55();
        System.out.println(test55.canJump(nums));
    }
}
