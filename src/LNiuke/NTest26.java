package LNiuke;

import LeetCode.TreeNode;

/**
 * @author Administrator
 * @date 2020/7/7 16:36
 */

public class NTest26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B != null){
            return false;
        }
        if(B == null){
            return true;
        }
        if(A.val != B.val){
            isSubStructure(A.left,B);
            isSubStructure(A.right,B);
        }
        return isSubStructure(A.left,B.left) && isSubStructure(A.right,B.right);
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        //TreeNode l4 = new TreeNode(1);
        //TreeNode l5 = new TreeNode(2);
        l1.left = l2;
        l1.right = l3;
        //l3.left = l4;
        //l3.right = l5;

        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(1);
        r1.left = r2;

        NTest26 nTest26 = new NTest26();
        System.out.println(nTest26.isSubStructure(l1, r1));
    }
}
