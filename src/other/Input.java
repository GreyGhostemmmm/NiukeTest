package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Administrator
 * @date 2020/7/18 16:46
 */

public class Input {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.trim().split(" ");
        Integer n1 = Integer.parseInt(str1[0]);
        Integer n2 = Integer.parseInt(str1[0]);

        String s1 = br.readLine();
        String[] str2 = s1.trim().split(" ");
        int[] nums = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums[i] = Integer.parseInt(str2[i]);
        }
        for (int i = 0; i < n1; i++) {
            System.out.println(nums[i]);
        }
    }
}
