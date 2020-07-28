package LNiuke;

import LeetCode.TreeNode;

/**
 * @author Administrator
 * @date 2020/7/16 19:07
 */

public class NTest55 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.abs(left-right) <= 1 ? true : false;
    }

    int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left) + 1;
        int right = treeDepth(root.right) + 1;
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(3);
        TreeNode t41 = new TreeNode(4);
        TreeNode t42 = new TreeNode(4);
        t11.left = t21;
        t11.right = t22;
        t21.left = t31;
        t22.right = t32;
        t31.left = t41;
        t32.right = t42;
        NTest55 nTest55 = new NTest55();
        System.out.println(nTest55.isBalanced(t11));

    }
}
