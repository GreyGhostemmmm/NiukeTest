package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/10 19:58
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


public class NTest36 {
    public Node treeToDoublyList(Node root) {
        Node head = getList(root);
        Node cur = head;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = head;
        head.left = cur;
        return head;
    }

    Node getList(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        Node leftHead = getList(root.left);
        Node rightHead = getList(root.right);
        if(rightHead != null){
            rightHead.left = root;
            root.right = rightHead;
        }
        if(leftHead != null){
            Node p = leftHead;
            while(p.right != null){
                p = p.right;
            }
            p.right = root;
            root.left = p;
            return leftHead;
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(3);

        //n1.left = n2;
        n1.right =n3;
        //n2.left = n4;
        //n2.right = n5;

        NTest36 nTest36 = new NTest36();
        Node head = nTest36.treeToDoublyList(n1);
        System.out.println(head.val);
        List<Integer> list = Arrays.asList(1,2,3);
        int num = 66;
        list.add(num);
    }
}
