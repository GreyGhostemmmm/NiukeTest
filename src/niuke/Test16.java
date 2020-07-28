package niuke;

/**
 * @author Administrator
 * @date 2020/2/17 10:16
 */

public class Test16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p = null;
        ListNode temp = null;
        while((p1 != null)&&(p2 != null)){
            if(p1.val <= p2.val){
                if(p == null){
                    p = p1;
                    temp = p;
                }
                else{
                    p.next = p1;
                    p = p.next;
                }
                p1 = p1.next;
            }
            else{
                if(p == null){
                    p = p2;
                    temp = p;
                }
                else{
                    p.next = p2;
                    p = p.next;
                }
                p2 = p2.next;
            }
        }
        if((p1 == null) && (p2 != null)){
            p.next = p2;
        }
        else if((p2 == null) && (p1 != null)){
            p.next = p1;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        Test16 test16 = new Test16();
        ListNode p = test16.Merge(list1,list2);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
