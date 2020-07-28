package niuke;

/**
 * @author Administrator
 * @date 2020/3/26 22:53
 */

public class Test52 {
    public boolean match(char[] str, char[] pattern)
    {
        boolean flag = false;
        int length1 = str.length - 1;
        int length2 = pattern.length - 1;
        char temp = '0';
        while(length1 >= 0 && length2 >= 0){
            if(str[length1] == pattern[length2] || pattern[length2] == '.'){
                length1--;
                length2--;
            }
            else if(pattern[length2] == '*'){
                length2--;
                if(str[length1] == pattern[length2] || pattern[length2] == '.')
                    continue;
                else{
                    temp = pattern[length2];
                    while(temp == pattern[length2]){
                        length2--;
                    }
                }
            }

            else
                break;
        }
        if(length1 == -1 && length2 == -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = ".*";
        char[] str = s1.toCharArray();
        char[] pattern = s2.toCharArray();
        Test52 test52 = new Test52();
        System.out.println(test52.match(str,pattern));
    }
}
