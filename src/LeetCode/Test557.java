package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/16 10:22
 */

public class Test557 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++){
            StringBuilder sb = new StringBuilder(str[i]);
            int left = 0;
            int right = str[i].length() - 1;
            reverse(sb,left,right);
            str[i] = sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb = sb.append(str[i]).append(" ");
        }
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }

    void reverse(StringBuilder sb, int left, int right){
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Test557 test557 = new Test557();
        System.out.println(test557.reverseWords(s));

        List<String> list  = new ArrayList<>();
        String[] str = list.toArray(new String[list.size()]);
    }
}
