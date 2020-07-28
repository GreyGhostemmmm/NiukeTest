package LeetCode;

import LNiuke.NTest37;

/**
 * @author Administrator
 * @date 2020/7/7 15:09
 */

public class Test112 {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return flag;
        }
        dfs(root, sum);
        return flag;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            flag = true;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        sum = sum + root.val;
    }

    public static void main(String[] args) {
        String s = "[5,4,8,11,null,13,4,7,2,null,null,null,1,null,null,null,null,null,null]";
        NTest37 nTest37 = new NTest37();
        TreeNode root = nTest37.deserialize(s);
        Test112 test112 = new Test112();
        System.out.println(test112.hasPathSum(root, 22));
    }
}
