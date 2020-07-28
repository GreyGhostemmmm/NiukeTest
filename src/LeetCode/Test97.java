package LeetCode;

/**
 * @author Administrator
 * @date 2020/7/18 12:40
 */

public class Test97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int len3 = c3.length;
        if(len1 + len2 != len3){
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && c1[i-1] == c3[i-1]; i++) dp[i][0] = true;
        for (int j = 1; j <= len2 && c2[j-1] == c3[j-1]; j++) dp[0][j] = true;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i-1][j] && c1[i-1] == c3[i+j-1]) || (dp[i][j-1] && c2[j-1] == c3[i+j-1]);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "b";
        String s3 = "b";
        Test97 test97 = new Test97();
        System.out.println(test97.isInterleave(s1, s2, s3));
    }
}
