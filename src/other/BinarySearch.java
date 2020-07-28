package other;

/**
 * @author Administrator
 * @date 2020/7/13 17:15
 */

public class BinarySearch {
    public int binary_search(int start,int end,int target,int a[]){
        if(start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (target > a[mid]) {
                //target >和=都判断过了a[mid] 那么下次开始的位置应该越过mid的后一个位置
                return binary_search(mid + 1, end, target, a);
            } else if (target < a[mid]) {
                //target <和=都判断过了a[mid] 那么下次结束的位置应该越过end到mid的前一个位置
                return binary_search(start, mid - 1, target, a);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        int target = 80;
        int start = 0;
        int end = a.length-1;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binary_search(start,end,target,a);
        System.out.println(a[result]);
    }
}
