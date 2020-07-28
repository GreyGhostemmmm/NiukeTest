package niuke;

/**
 * @author Administrator
 * @date 2020/2/16 10:22
 */

public class Test11 {
    public int NumberOf1(int n) {
        byte[] result = new byte[4];
        result[0]=(byte)((n >> 24)& 0xFF);
        result[1]=(byte)((n >> 16)& 0xFF);
        result[2]=(byte)((n >> 8)& 0xFF);
        result[3]=(byte)(n & 0xFF);
        int sum = 0;
        for(int j = 0;j < 4;j++){
            for(int i = 0;i < 8;i++){
                if(((result[j] >> i)& 1) != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        test11.NumberOf1(1023);
    }
}
