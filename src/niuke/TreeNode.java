package niuke;

import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/2/19 10:38
 */

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    //获取树深度
    static int depth(TreeNode root){
        if(root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }

    //后序递归
    static void last(TreeNode root){
        if(root != null){
            last(root.left);
            last(root.right);
            System.out.println(root.val);
        }
    }

    //后序非递归
    static void lastOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode last = null;
        TreeNode top = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if((top.right == null)||(top.right == last)){
                stack.pop();
                System.out.println(top.val);
                last = top;
            }
            else{
                cur = top.right;
            }
        }
    }

    //找祖先
    static void findBirth(TreeNode root,int value){
        TreeNode cur = root;
        TreeNode last = null;
        TreeNode top = null;
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if(top.val == value)
                flag = true;
            if(flag){
                stack.pop();
                while(!stack.empty()){
                    System.out.println(stack.peek().val);
                    stack.pop();
                }
                return;
                /*result = stack.peek().val;
                return result;*/
            }
            if((top.right == null)||(top.right == last)){
                stack.pop();
                last = top;
            }
            else{
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        TreeNode.findBirth(root,3);
        //System.out.println(niuke.TreeNode.depth(root));
       /* niuke.TreeNode.lastOrder(root);
        niuke.TreeNode.last(root);*/
    }
}
