package LNiuke;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2020/7/29 16:18
 */

public class NTest41 {
    Queue<Integer> A, B;

    public NTest41() {
        A = new PriorityQueue<>();  //小顶堆
        B = new PriorityQueue<>((o1, o2) -> (o2 - o1));     //大顶堆
    }

    public void addNum(int num) {
        if(A.size() != B.size()){
            B.offer(num);
            A.offer(B.poll());
        }else{
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() != B.size()) {
            return B.peek() * 1.0;
        } else {
            return (A.peek() + B.peek()) / 2.0;
        }
    }
}
