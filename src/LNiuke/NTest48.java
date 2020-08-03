package LNiuke;

import java.util.HashSet;

/**
 * @author Administrator
 * @date 2020/7/30 19:32
 */

public class NTest48 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        int begin = 0;
        int end = 0;
        int len = s.length();
        int max = 1;
        int count = 0;
        while(end < len){
            if(!set.contains(c[end])){
                set.add(c[end]);
                end++;
            }
            else{
                count = end - begin;
                max = max > count ? max : count;
                while(c[begin] != c[end]){
                    set.remove(c[begin]);
                    begin++;
                }
                set.remove(c[begin]);
                begin++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NTest48 nTest48 = new NTest48();
        String s = "ddd";
        System.out.println(nTest48.lengthOfLongestSubstring(s));
    }
}
