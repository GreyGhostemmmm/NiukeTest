package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/8/2 16:49
 */

public class Test84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length <= 0){
            return 0;
        }
        int maxSize = 0;
        int curSize = 0;
        int index = 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right,len);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                index = stack.pop();
                right[index] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < len; ++i) {
            curSize = (right[i] - left[i] - 1) * heights[i];
            maxSize = Math.max(curSize,maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] n = {2,1,5,6,2,3};
        Test84 test84 = new Test84();
        System.out.println(test84.largestRectangleArea(n));
    }
}
