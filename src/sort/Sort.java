package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Administrator
 * @date 2020/7/1 14:37
 */

public class Sort {

    void bubbleSort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    void selectionSort(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    void insertionSort(int[] nums) {
        int preIndex = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            preIndex = i - 1;
            temp = nums[i];
            while (preIndex >= 0 && temp < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = temp;
        }
    }

    void shellSort(int[] nums){
        int len = nums.length;
        for (int gap = len / 2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = nums[i];
                while (j - gap >= 0 && current < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }
    }

    int[] mergeSort(int nums[]) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1 + len2];
        for (int i = 0, j = 0, index = 0; index < len1 + len2; index++) {
            if (i >= nums1.length) {
                result[index] = nums2[j++];
            } else if (j >= nums2.length) {
                result[index] = nums1[i++];
            } else {
                if (nums1[i] >= nums2[j]) {
                    result[index] = nums2[j];
                    j++;
                } else {
                    result[index] = nums1[i];
                    i++;
                }
            }
        }
        return result;
    }

    int[] quickSort(int[] nums, int begin, int end) {
        int center = 0;
        if (begin < end) {
            center = quick(nums, begin, end);
            quickSort(nums, begin, center - 1);
            quickSort(nums, center + 1, end);
        }
        return nums;
    }

    int quick(int[] nums, int begin, int end) {
        int i = begin + 1;
        int j = end;
        int pivot = nums[begin];
        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        nums[begin] = nums[j];
        nums[j] = pivot;
        return j;
    }

    void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, j - 1);
        }
    }

    void adjustHeap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        for (int i = 2 * begin + 1; i <= end; i = i * 2 + 1) {
            if (i + 1 <= end && nums[i + 1] > nums[i]) {
                i = i + 1;
            }
            if (nums[i] > temp) {
                nums[begin] = nums[i];
                begin = i;
            }
        }
        nums[begin] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 4, 7, 9, 5, 2, 3, 8, 6};
        Sort sort = new Sort();
        int res[] = sort.quickSort(nums, 0, nums.length - 1);
        //sort.shellSort(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
