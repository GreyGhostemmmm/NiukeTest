package LNiuke;

/**
 * @author Administrator
 * @date 2020/7/6 15:47
 */

public class NTest33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length < 2){
            return true;
        }
        int len = postorder.length;
        return verify(postorder,0,len-1);
    }

    boolean verify(int[] postorder, int begin, int end){
        if(begin >= end){
            return true;
        }
        int root = postorder[end];
        int temp = begin;
        for(; temp < end; temp++){
            if(postorder[temp] > root){
                //temp = i;
                break;
            }
        }
        for(int j = temp; j < end; j++){
            if(postorder[j] < root){
                return false;
            }
        }
        return verify(postorder,begin,temp-1) && verify(postorder,temp,end-1);
    }

    public static void main(String[] args) {
        int[] i = {4,6,7,5};
        NTest33 nTest33 = new NTest33();
        System.out.println(nTest33.verifyPostorder(i));
    }
}
