package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/28 16:16
 */

public class Test102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int sum = 1;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.removeFirst();
            list.add(temp.val);
            sum--;
            if(temp.left != null){
                queue.addLast(temp.left);
            }
            if(temp.right != null){
                queue.addLast(temp.right);
            }
            if(sum == 0){
                result.add(new LinkedList<>(list));
                list = new LinkedList<>();
                sum = queue.size();
            }
        }
        return result;
    }
}
