package niuke;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2020/4/1 16:40
 */

public class Test55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //如果pHead为空，则输出null
        if(pHead == null)
            return null;
        //将遍历的指针加入List，进行比对
        ListNode temp = pHead;
        ArrayList<ListNode> list = new ArrayList<>();
        while(temp != null){
            if(!list.contains(temp)){
                list.add(temp);
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }
}
