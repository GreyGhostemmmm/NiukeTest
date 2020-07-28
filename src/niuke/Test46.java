package niuke;

/**
 * @author Administrator
 * @date 2020/3/18 18:26
 */

public class Test46 {
    static int LastRemaining_Solution(int n, int m) {
        if(n == 0)
            return -1;
        int last = 0;
        int count = 0;
        int index = 0;
        int flag = 0;
        int num[] = new int[n];
        while(count < n){
            while(flag < m){
                index = index + 1;
                if(index - 1 == n){
                    index = 1;
                }
                while(num[index-1] == 1){
                    if(index == n){
                        index = 1;
                    }
                    else{
                        index++;
                    }
                }
                flag++;
            }
            num[index-1] = 1;
            last = index - 1;
            flag = 0;
            count++;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(Test46.LastRemaining_Solution(5,3));
        System.out.println(2%5);
    }
}
