package niuke;

/**
 * @author Administrator
 * @date 2020/3/25 15:48
 */
public class Exam01 {
    public int result(int[][] num,int count){
        int rows = num.length;
        int columns = num[1].length;
        int sum = 0;
        int temp = 0;
        for(int i = 0;i < columns - 1;i++){
            int num1 = Math.abs(num[1][i]-num[1][i+1]);
            int num2 = Math.abs(num[1][i]-num[2][i+1]);
            int num3 = Math.abs(num[1][i]-num[3][i+1]);
            int num4 = Math.abs(num[2][i]-num[1][i+1]);
            int num5 = Math.abs(num[2][i]-num[2][i+1]);
            int num6 = Math.abs(num[2][i]-num[3][i+1]);
            int num7 = Math.abs(num[3][i]-num[1][i+1]);
            int num8 = Math.abs(num[3][i]-num[2][i+1]);
            int num9 = Math.abs(num[3][i]-num[3][i+1]);
            temp = min(num9,min(num8,min(num7,min(num6,min(num5,min(num4,min(num3, min(num1,num2))))))));
            sum = sum + temp;
        }
        return sum;
    }

    public  int min(int a, int b) {
        return (a <= b) ? a : b;
    }

    public static void main(String[] args) {
        int num[][] = {{5},{5,9,5,4,4},{4,7,4,10,3},{2,10,9,2,3}};
        Exam01 exam01 = new Exam01();
        System.out.println(num[1].length);
        int sum = exam01.result(num,5);
        System.out.println(sum);
        System.out.println(num.length);
    }
}
