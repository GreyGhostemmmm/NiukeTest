package niuke;

/**
 * @author Administrator
 * @date 2020/3/31 17:43
 */

public class Test53 {
    public boolean isNumeric(char[] str) {
        int length = str.length;
        boolean flag = false;
        //如果长度为0
        if(length == 0)
            return flag;
        int dotCount = 0;
        int eCount = 0;
        int signCount = 0;
        for(int i = 0;i < length;i++){
            //正负号判断，如果在第0个位置出现或在e之后出现则可以
            if(str[i] == '+' || str[i] == '-'){
                signCount++;
                if(signCount > 2)
                    return flag;
                else if(i == 0){
                    continue;
                }
                else if(i == length - 1)
                    return flag;
                else if(str[i-1] == 'e' || str[i-1] == 'E'){
                   continue;
                }
                else if(str[i+1] == '.' ){
                    continue;
                }
                else
                    return flag;
            }
            //数字判断，直接继续
            else if(str[i] >= '0'&&str[i] <= '9'){
                continue;
            }
            //科学计数法判断，确定其前一字符是否为数字，后一字符是否为数字或负号
            else if(str[i] == 'E' || str[i] == 'e'){
                eCount++;
                if(eCount > 1)
                    return flag;
                else if(i == 0)
                    return flag;
                else if(i == length - 1)
                    return flag;
                else if(str[i-1] < '0'||str[i-1] > '9'){
                    return flag;
                }
                else if(str[i+1] < '0'||str[i+1] > '9'){
                    if((str[i+1] != '-'&&str[i+1] != '+')){
                        return flag;
                    }
                }
            }
            //小数点判断，前后均需要为数字，且只能出现一次
            else if(str[i] == '.'){
                dotCount++;
                if(dotCount > 1 || eCount > 0){
                    return flag;
                }
                else if(i == length - 1)
                    return flag;
                else if(str[i-1] < '0'||str[i-1] > '9'){
                    if((str[i-1] != '-'&&str[i-1] != '+')){
                        return flag;
                    }
                }
                else if(str[i+1] < '0'||str[i+1] > '9'){
                    return flag;
                }
            }
            //其他情况，直接返回flag
            else
                return flag;
        }
        //循环完毕，则为数字
        flag = true;
        return flag;
    }

    public static void main(String[] args) {
        String str = "1.2.3";
        char[] array = str.toCharArray();
        Test53 test53 = new Test53();
        System.out.println(test53.isNumeric(array));
    }
}
