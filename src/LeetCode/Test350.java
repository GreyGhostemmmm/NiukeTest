package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/13 15:16
 */

public class Test350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            return getList(nums2,nums1);
        }
        return getList(nums1,nums2);
    }

    int[] getList(int[] nums1, int[] nums2){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[nums2.length];
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(!flag[j] && nums2[j] == nums1[i]){
                    list.add(nums1[i]);
                    flag[j] = true;
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int[] nums2 = {2,2,};
        Test350 test350 = new Test350();
        int[] res = test350.intersect(nums1,nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
