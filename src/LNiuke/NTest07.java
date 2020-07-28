package LNiuke;

import LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2020/7/7 17:10
 */

public class NTest07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = helper(preorder,inorder,0,preorder.length - 1,0,inorder.length-1);
        return root;
    }

    TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd){
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int i = iStart;
        while(inorder[i] != preorder[pStart]){
            i++;
        }
        int j = i - iStart;
        root.left = helper(preorder,inorder,pStart+1,pStart+j,iStart,i-1);
        root.right = helper(preorder,inorder,pStart+j+1,pEnd,i+1,iEnd);
        return root;
    }

    public static void main(String[] args) {
        /*int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};*/
        int a[] = {1,2,3};
        int b[] = {3,2,1};
        NTest07 nTest07 = new NTest07();
        TreeNode root = nTest07.buildTree(a,b);
        System.out.println(root.val);
    }
}
