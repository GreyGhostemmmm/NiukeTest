package LeetCode;

import java.util.HashMap;

/**
 * @author Administrator
 * @date 2020/6/29 15:32
 */

public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int count = 1;
        int temp = 0;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
        for (int j = len - 1; j >= 0; j--) {
            if (count == k) {
                return nums[0];
            }
            if(j < 0){
                break;
            }
            temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            count++;
            adjustHeap(nums, 0, j);
        }
        return -1;
    }

    void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && nums[j + 1] > nums[j]) {
                j = j + 1;
            }
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Test215 test215 = new Test215();
        int nums[] = {2,1};
        System.out.println(test215.findKthLargest(nums, 2));
    }
}
