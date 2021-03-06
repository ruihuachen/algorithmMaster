package com.algorithm.leetcode.二叉树最小路径;
import java.util.*;

/**
 * create by Ernest on 2020/2/7.
 */
public class MinimumTotal {

    private int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j>= 0; j--) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[j] = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
            }
        }
        return dp[triangle.size()];
    }



    public static void main(String[] args) {
        MinimumTotal mt = new MinimumTotal();

        int result = mt.minimumTotal(Arrays.asList(
                Arrays.asList(   2),
                Arrays.asList(  3,4),
                Arrays.asList( 6,5,7),
                Arrays.asList(4,1,8,3)
        ));
        System.out.println(result);
    }
}
