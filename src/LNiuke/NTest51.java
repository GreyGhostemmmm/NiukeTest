package LNiuke;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2020/7/12 18:49
 */

public class NTest51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        if(nums.length < 2){
            return count;
        }
        mergeSort(nums);
        return count;
    }

    public int[] mergeSort(int[] nums){
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int len1 = left.length;
        int len2 = right.length;
        int[] result = new int[len1+len2];
        for(int index = 0, i= 0, j = 0; index < len1 + len2; index++){
            if(i >= len1){
                result[index] = right[j++];
            }
            else if(j >= len2){
                result[index] = left[i++];
                count = count + len2;
            }
            else{
                if(left[i] <= right[j]){
                    result[index] = left[i];
                    count = count + j;
                    i++;
                }
                else if(left[i] > right[j]){
                    result[index] = right[j];
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,2,3,1};
        NTest51 nTest51 = new NTest51();
        System.out.println(nTest51.reversePairs(nums));
    }
}
