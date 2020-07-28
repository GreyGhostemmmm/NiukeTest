package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2020/7/23 19:56
 */

public class Test123 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        Queue<Integer> pq = new PriorityQueue<>();
        int start = 0;
        int end = -1;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] >= prices[i]) {
                if (end > start) {
                    sum = prices[end] - prices[start];
                    if (pq.size() < 2) {
                        pq.offer(sum);
                    } else if (sum > pq.peek()) {
                        pq.poll();
                        pq.offer(sum);
                    }
                }
                start = i;
            } else if(prices[i-1] < prices[i]){
                end = i;
                if(end == len -1){
                    sum = prices[end] - prices[start];
                    if (pq.size() < 2) {
                        pq.offer(sum);
                    } else if (sum > pq.peek()) {
                        pq.poll();
                        pq.offer(sum);
                    }
                }
            }
        }
        if(end == -1){
            return 0;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res = res + pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        Test123 test123 = new Test123();
        System.out.println(test123.maxProfit(nums));
    }
}
