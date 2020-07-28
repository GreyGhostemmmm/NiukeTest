package niuke;

/**
 * @author Administrator
 * @date 2020/2/19 20:06
 */

public class Test23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return check(sequence,0,sequence.length-1);
    }

    public boolean check(int[] arr,int start,int end){
        if(start >= end)
            return true;

        int index = start;
        for(;index < end;index++){
            if(arr[index] > arr[end])
                break;
        }

        for(int i = index;i < end;i++){
            if(arr[i] < arr[end])
                return false;
        }

        boolean left = check(arr,start,index-1);
        boolean right = check(arr,index,end-1);
        return left&&right;
        //return check(arr,start,index-1)&&check(arr,index,end-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,7,6,4};
        Test23 test23 = new Test23();
        boolean text = test23.VerifySquenceOfBST(arr);
        System.out.println(text);
    }
}
