package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/7/14 15:36
 */

public class Test120 {
    int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        calDepth(triangle, 0, height, 0, 0);
        return min;
    }

    void calDepth(List<List<Integer>> triangle, int level, int height, int sum, int upIndex) {
        if (level == height) {
            min = sum < min ? sum : min;
            return;
        }
        if (upIndex + 1 < triangle.get(level).size()) {
            calDepth(triangle, level + 1, height, sum + triangle.get(level).get(upIndex + 1), upIndex + 1);
        }
        if (upIndex >= 0) {
            calDepth(triangle, level + 1, height, sum + triangle.get(level).get(upIndex), upIndex);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Test120 test120 = new Test120();
        System.out.println(test120.minimumTotal(triangle));
    }
}
