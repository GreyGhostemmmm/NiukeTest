package LeetCode;

import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/8/2 17:25
 */

public class Test42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int cur = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(height[i], height[stack.peek()]) - height[cur];
                sum = sum + h * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] n = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 3, 1, 2, 1};
        Test42 test42 = new Test42();
        System.out.println(test42.trap(n));
    }
}
