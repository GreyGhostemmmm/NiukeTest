package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/2 20:26
 */

public class Test60 {
    String s = "";
    int res = 0;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] flag = new boolean[n];
        getResult(nums, flag, 0, 0, k);
        return s;
    }

    void getResult(int[] nums, boolean[] flag, int count, int sum, int k) {
        if (count == nums.length) {
            res++;
            if (res == k) {
                s = sum + "";
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    getResult(nums, flag, count + 1, sum * 10 + nums[i], k);
                    flag[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test60 test60 = new Test60();
        System.out.println(test60.getPermutation(4, 9));
    }
}
