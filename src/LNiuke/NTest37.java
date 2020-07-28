package LNiuke;

import LeetCode.TreeNode;

import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2020/7/6 18:45
 */

public class NTest37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                sb.append(cur.left.val).append(",");
                queue.offer(cur.left);
            }
            else{
                sb.append("null,");
            }
            if(cur.right != null){
                sb.append(cur.right.val).append(",");
                queue.offer(cur.right);
            }
            else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        String res = sb.toString();
        return res;
        /*if (root == null) {
            return "[]";
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        StringBuilder s = new StringBuilder("[");
        TreeNode top = null;
        while (!list.isEmpty()) {
            top = list.poll();
            if (top != null) {
                s.append(top.val + ",");
                list.offer(top.left);
                list.offer(top.right);
            } else {
                s.append("null,");
            }
        }
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();*/
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /*if (data.equals("[]")) {
            return null;
        }
        String newData = data.substring(1, data.length() - 1);
        String[] s = newData.split(",");
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        TreeNode cur = root;
        list.addFirst(root);
        for (int i = 0; i < s.length / 2; i++) {
            if ("null".equals(s[i])) {
                continue;
            }
            TreeNode left = null;
            TreeNode right = null;
            if (!"null".equals(s[2 * i + 1])) {
                left = new TreeNode(Integer.parseInt(s[2 * i + 1]));
            }
            if (!"null".equals(s[2 * i + 2])) {
                right = new TreeNode(Integer.parseInt(s[2 * i + 2]));
            }
            cur.left = left;
            cur.right = right;
            list.addLast(left);
            list.addLast(right);
            list.removeFirst();
            cur = list.getFirst();
        }
        return root;*/
        if(data.equals("[]")){
            return null;
        }
        String newData = data.substring(1, data.length() - 1);
        String[] s = newData.split(",");
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        TreeNode cur = null;
        list.addFirst(root);
        int i = 1;
        while(!list.isEmpty()){
            cur = list.poll();
            if(!"null".equals(s[i])){
                cur.left = new TreeNode(Integer.parseInt(s[i]));
                list.offer(cur.left);
            }
            i++;
            if(!"null".equals(s[i])){
                cur.right = new TreeNode(Integer.parseInt(s[i]));
                list.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String s = "[1,2,5,3,null,4,6]";
        NTest37 nTest37 = new NTest37();
        /*TreeNode root = nTest37.deserialize(s);
        System.out.println(root.val);*/
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        String str = nTest37.serialize(t1);
        System.out.println(str);
        TreeNode root = nTest37.deserialize(s);
        System.out.println(root.val);
    }
}
