package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/18 10:30
 */

public class Test93 {
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        String[] str = new String[4];
        dfs(s, str, 0, 0);
        return list;
    }

    void dfs(String s, String[] str, int index, int count) {
        if (count == 4 && index == s.length()) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 4; i++) {
                sb.append(str[i]).append(".");
            }
            String res = sb.toString();
            list.add(res.substring(0, res.length()-1));
            return;
        }

        int remainCount = 4 - count;
        int remainsChars = s.length() - index;
        // 判断剩余的字符是否有解
        if (remainCount > remainsChars || remainCount * 3 < remainsChars) {
            return;
        }
        int maxLen = s.charAt(index) == '0' ? 1 : 3;
        for (int i = 0; i < maxLen && i + index < s.length(); i++) {
            if (i == 2 && (s.charAt(index) - '0') * 100 + (s.charAt(index + 1) - '0') * 10 + (s.charAt(index + 2) - '0') > 255) {
                continue;
            }
            str[count] = s.substring(index, index + i + 1);
            dfs(s, str, index + i + 1, count + 1);
            str[count] = "";
        }
    }

    public static void main(String[] args) {
        String s = "1111";
        Test93 test93 = new Test93();
        System.out.println(test93.restoreIpAddresses(s));
    }
}
