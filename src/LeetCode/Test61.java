package LeetCode;

import niuke.ListNode;

/**
 * @author Administrator
 * @date 2020/7/3 15:48
 */

public class Test61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode p = head;
        int n = 1;
        while(p.next != null){
            n++;
            p = p.next;
        }
        p.next = head;
        p = head;
        for(int i = 0; i < n - k % n - 1; i++){
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Test61 test61 = new Test61();
        ListNode head = test61.rotateRight(l1,3);
        while(head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
