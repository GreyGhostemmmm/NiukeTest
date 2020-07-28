package other;

import LeetCode.TreeNode;

import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/7/8 10:54
 */

public class Tree {

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public void npreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            while (cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
    }

    public void ninOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while(!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

    public void npostOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode last = null;
        while(!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if(top.right == null || top.right == last){
                last = stack.pop();
                System.out.println(top.val);
            }
            else{
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;

        Tree tree = new Tree();
        tree.npostOrder(t1);
    }
}
