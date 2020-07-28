package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/7/18 14:30
 */

public class Test99 {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double temp = -Double.MAX_VALUE;
        ArrayList<TreeNode> list = new ArrayList<>();
        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            list.add(top);
            cur = top.right;
        }
        TreeNode t1 = null;
        TreeNode t2 = null;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i).val > list.get(i+1).val){
                if(t1 == null){
                    t1 = list.get(i);
                }else{
                    t2 = list.get(i);
                    break;
                }
            }
        }
        int num = t1.val;
        t1.val = t2.val;
        t2.val = num;
    }

    public static void main(String[] args) {
        Test99 test99 = new Test99();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t3.right = t2;
        test99.recoverTree(t1);
        System.out.println(t1.val);
    }
}
