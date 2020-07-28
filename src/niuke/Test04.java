package niuke;

/**
 * @author Administrator
 * @date 2020/2/13 17:58
 */

public class Test04 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private int [] pre;  //前序遍历数组
    private int pre_index = 0;   //用来遍历前序遍历数组的下标

    TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode tree = new TreeNode(pre[0]);
        int temp = 0;
        //先序只有一个数
        if(pre.length == 1){
            tree.left = null;
            tree.right = null;
            return tree;
        }
        //找到中序中根的位置
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                temp = i;
                break;
            }
        }
        int left = temp;
        int right = in.length - temp - 1;
        int pre_left[] = new int[left];
        int in_left[] = new int[left];
        int pre_right[] = new int[right];
        int in_right[] = new int[right];
        //左子树
        if (left > 0) {
            for(int i = 0; i < left; i++) {
                pre_left[i] = pre[i+1];
            }
            for(int i = 0; i < left; i++){
                in_left[i] = in[i];
            }
            tree.left = reConstructBinaryTree(pre_left, in_left);
        }
        else{
            tree.left = null;
        }
        //右子树
        if (right > 0) {
            for (int i = temp + 1; i < pre.length; i++) {
                pre_right[i - temp - 1] = pre[i];
            }
            for (int i = temp + 1; i < in.length; i++) {
                in_right[i - temp - 1] = in[i];
            }
            tree.right = reConstructBinaryTree(pre_right, in_right);
        }
        else {
            tree.right = null;
        }
        return tree;
    }

    public static void main(String[] args){
        int pre[] = {1,2,3,4,5,6,7};
        int in[] = {3,2,4,1,6,5,7};

        TreeNode tree = new Test04().reConstructBinaryTree(pre,in);
        System.out.println(tree.right.val);
    }
}


/*public niuke.TreeNode LeftNodeAndRightNode( int x, int y, int shuzu[] ) {   //主递归方法，x左边界，y右边界，shuzu中序遍历数组
        int index = Find ( pre[ this.pre_index++ ], x, y, shuzu ); //调用Find方法判断下一个根节点pre[]在中序数组shuzu中的下标
        niuke.TreeNode temp = new niuke.TreeNode( shuzu[index] ); //新建子树根结点
        if ( index != x ) {  //如果存在左子树
            temp.left = LeftNodeAndRightNode( x, index-1, shuzu );  //递归，寻找左子树
        }
        if( index != y ) {  //如果存在右子树
            temp.right = LeftNodeAndRightNode( index+1, y, shuzu );  //递归，寻找右子树
        }
        return temp;
    }

    public int Find( int target, int x, int y, int shuzu[] ) {  //返回target在数组shuzu中的位置
        int i;
        for ( i = x; i <= y; i++ ) {
            if ( shuzu[i] == target ) {
                break;
            }
        }
        return i;
    }

    public niuke.TreeNode reConstructBinaryTree(int [] pre,int [] in) {  //被main调用的方法，pre前序遍历，in中序遍历
        niuke.TreeNode tn = new niuke.TreeNode( pre[0] );  //创建整棵树的根节点
        this.pre = pre;
        int in_len = in.length;
        int rootNode_index = Find( pre[ pre_index++ ],0, in_len, in );  //找到整棵树的根节点在中序遍历序列中的位置
        if ( rootNode_index != 0 ) {  //如果存在左子树
            tn.left = LeftNodeAndRightNode( 0, rootNode_index-1, in );  //递归，寻找左子树
        }
        if ( rootNode_index != in_len-1 ) {   //如果存在右子树
            tn.right = LeftNodeAndRightNode( rootNode_index+1, in_len-1, in );  //递归，寻找右子树
        }
        return tn;
    }
*/