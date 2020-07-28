package LNiuke;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2020/7/22 16:35
 */

public class NTest40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || k > arr.length) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        int front = 0;
        int j = quickSort(arr, 0, arr.length - 1);
        while (true) {
            if (j == k) {
                break;
            } else if (j < k) {
                front = j;
                j = quickSort(arr, j + 1, arr.length - 1);
            } else {
                j = quickSort(arr, front + 1, j - 1);
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    int quickSort(int[] arr, int begin, int end) {
        int cur = arr[begin];
        int i = begin + 1;
        int j = end;
        while (true) {
            while (i <= j && arr[i] <= cur) {
                i++;
            }
            while (i <= j && arr[j] > cur) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[begin] = arr[j];
        arr[j] = cur;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1};
        NTest40 ntTest40 = new NTest40();
        int[] res = ntTest40.getLeastNumbers(nums, 3);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
