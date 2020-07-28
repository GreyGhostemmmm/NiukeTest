package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2020/2/19 10:38
 */

public class Test22 {
    int sum = 0;
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList <Integer>list=new ArrayList<Integer>();
        if(root==null)return list;
            queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t=queue.poll();
            list.add(t.val);
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            }
        }
        return list;
    }

        public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
            ArrayList <TreeNode> treelist=new ArrayList<TreeNode> ();
            ArrayList <Integer> tlist=new ArrayList<Integer>();
            if(root==null)
                return tlist;
            treelist.add(root);
            tlist.add(root.val);
            for(int i=0;i<treelist.size();i++){
                TreeNode node =treelist.get(i);
                if(node.left!=null){
                    treelist.add(node.left);
                    tlist.add(node.left.val);
                }

                if(node.right!=null){
                    treelist.add(node.right);
                    tlist.add(node.right.val);
                }
            }
            return tlist;
        }

    void PreOrderTraverse(TreeNode T)
    {
        if(T == null) {
            return;
        }
        sum = sum + T.val;
        //System.out.println(T.val);  /*显示结点数据，可以更改为其他对结点操作*/
        PreOrderTraverse(T.left);    /*再先序遍历左子树*/
        PreOrderTraverse(T.right);    /*最后先序遍历右子树*/
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        Test22 test22 = new Test22();
        test22.PreOrderTraverse(root);
        System.out.println(test22.sum);
        //test22.PrintFromTopToBottom2(root);
    }
}
