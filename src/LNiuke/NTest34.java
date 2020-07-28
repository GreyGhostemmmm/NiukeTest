package LNiuke;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/6 16:47
 */

public class NTest34 {
    LinkedList<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        LinkedList<Integer> list = new LinkedList<>();
        getPath(root,sum,list);
        return result;
    }

    public void getPath(TreeNode root, int sum, LinkedList<Integer> list){
        if(root == null){
            return;
        }
        list.addLast(root.val);
        if(sum - root.val== 0 && root.left == null && root.right == null){
            result.add(new LinkedList(list));
        }
        getPath(root.left,sum-root.val,list);
        getPath(root.right,sum-root.val,list);
        list.removeLast();
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        NTest34 nTest34 = new NTest34();
        System.out.println(nTest34.pathSum(l1, 0));
    }
}
