package sort;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2020/7/19 15:59
 */

public class Sort2 {

    //快速排序
    void quickSort(int nums[], int begin, int end) {
        if (begin < end) {
            int index = quick(nums, begin, end);
            quickSort(nums, begin, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    int quick(int[] nums, int begin, int end) {
        int temp = nums[begin];
        int i = begin + 1;
        int j = end;
        while (true) {
            while (i <= j && nums[i] <= temp) {
                i++;
            }
            while (i <= j && nums[j] > temp) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int cur = nums[j];
            nums[j] = nums[i];
            nums[i] = cur;
        }
        nums[begin] = nums[j];
        nums[j] = temp;
        return j;
    }

    //归并排序
    int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    int[] merge(int[] left, int[] right) {
        int len1 = left.length;
        int len2 = right.length;
        int[] res = new int[len1 + len2];
        for (int index = 0, i = 0, j = 0; index < len1 + len2; index++) {
            if (i >= len1) {
                res[index] = right[j++];
            } else if (j >= len2) {
                res[index] = left[i++];
            } else {
                if (left[i] > right[j]) {
                    res[index] = right[j++];
                } else if (left[i] <= right[j]) {
                    res[index] = left[i++];
                }
            }
        }
        return res;
    }

    //堆排序
    void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            buildHeap(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            buildHeap(nums, 0, i - 1);
        }
    }

    void buildHeap(int[] nums, int index, int end) {
        int temp = nums[index];
        int j = index;
        for (int i = 2 * index + 1; i <= end; i = 2 * i + 1) {
            if (i + 1 <= end && nums[i + 1] > nums[i]) {
                i = i + 1;
            }
            if (nums[i] > temp) {
                nums[j] = nums[i];
                j = i;
            }
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        Sort2 sort2 = new Sort2();
        //sort2.heapSort(nums);
        sort2.quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
