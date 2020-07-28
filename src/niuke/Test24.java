package niuke;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/2/21 11:17
 */

public class Test24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return arr;
        TreeNode node = root;
        TreeNode top = null;
        TreeNode last = null;
        int sum = 0;
        while((node != null)||(!stack.empty())){
            while(node != null){
                list.add(node.val);
                sum = sum + node.val;
                stack.push(node);
                node = node.left;
            }
            top = stack.peek();
            if((sum == target)&&(top.left == null)&&(top.right == null)){
                arr.add(new ArrayList<Integer>(list));
            }
            if((top.right == null)||(top.right == last)){
                stack.pop();
                list.remove(list.size()-1);
                sum = sum - top.val;
                last = top;
            }
            else{
                node = top.right;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        Test24 test24 = new Test24();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr = test24.FindPath(root,22);
        System.out.println(arr);
    }
}
