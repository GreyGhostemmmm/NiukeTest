package niuke;

/**
 * @author Administrator
 * @date 2020/3/25 21:19
 */

public class Test49 {
    public int StrToInt(String str) {
        if(str == null)
            return 0;
        //转换为char数组
        char num[] = str.toCharArray();
        int length = num.length;
        //如果长度为0，说明字符串为空
        if(length == 0)
            return 0;
        //和，符号位
        int sum = 0;
        int sign = 1;
        if(num[0] == '+')
            sign = 1;
        else if(num[0] == '-')
            sign = -1;
        else if(num[0]>='0' && num[0]<='9')
            sum = num[0] - '0';
        else
            return 0;
        if(length == 1)
            return sum*sign;
        for(int i = 1;i < length;i++){
            if(num[i]>='0' && num[i]<='9'){
                int result = sum;
                sum = sum * 10 + (num[i] - '0');
                if((sum-(num[i] - '0'))/10!=result)
                    return 0;
            }
            else{
                return 0;
            }
        }
        return sum*sign;
    }

    public static void main(String[] args) {
        String s = "-2147483649";
        Test49 test49 = new Test49();
        System.out.println(test49.StrToInt(s));
    }
}
