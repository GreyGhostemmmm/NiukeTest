package niuke;

/**
 * @author Administrator
 * @date 2020/4/1 18:28
 */

public class Test56 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        //如果链表为空，返回null
        if(pHead == null)
            return null;
        //使用三个指针遍历
        ListNode before = pHead;
        ListNode cur = pHead.next;
        ListNode after = cur.next;
        //链表长度小于3
        if(cur == null)
            return pHead;
        if(after == null){
            if(before.val == cur.val){
                before = null;
                return null;
            }
            else
                return pHead;
        }
        //链表长度大于3
        while(after != null){
            //起始位置重复
            if(before.val == cur.val){
                while(after != null&&cur.val == after.val){
                    after = after.next;
                }
                pHead = after;
                before = pHead;
                cur = before.next;
                if(cur != null){
                    after = cur.next;
                }
                else{
                    after = null;
                }
            }
            //其他位置出现重复值，删除
            else if(cur.val == after.val){
                while(after != null&&cur.val == after.val){
                    after = after.next;
                }
                before.next = after;
                cur = before.next;
                after = cur.next;
            }
            //未重复
            else{
                before = cur;
                cur = after;
                after = after.next;
            }
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        Test56 test56 = new Test56();
        ListNode p = test56.deleteDuplication(p1);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
