package other;

import niuke.ListNode;

/**
 * @author Administrator
 * @date 2020/6/29 16:51
 */

public class ReverseList {
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        ReverseList reverseList = new ReverseList();
        reverseList.reverse(p1);
    }
}
