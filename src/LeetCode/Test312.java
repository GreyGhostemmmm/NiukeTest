package LeetCode;

/**
 * @author Administrator
 * @date 2020/6/26 15:17
 */

public class Test312 {
    int max = 0;

    public int maxCoins(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = nums.length;
        int sum = 0;
        int result = dfs(nums, count, sum, nums.length);
        return result;
    }

    int dfs(int[] nums, int count, int sum, int len) {
        if (count == 0) {
            return max = sum > max ? sum : max;
        } else {
            int left = 1;
            int right = 1;
            int m = 0;
            int n = 0;
            int cur = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] != -1) {
                    for (m = i - 1; m > -1; m--) {
                        if (nums[m] != -1) {
                            left = nums[m];
                            break;
                        }
                    }
                    for (n = i + 1; n < len; n++) {
                        if (nums[n] != -1) {
                            right = nums[n];
                            break;
                        }
                    }
                    cur = nums[i];
                    nums[i] = -1;
                    dfs(nums, count - 1, sum + left * cur * right, len);
                    nums[i] = cur;
                    left = 1;
                    right = 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {7,9,8,0,7,1,3,5,5,2,3,3};
        Test312 test312 = new Test312();
        System.out.println(test312.maxCoins(nums));
    }
}
