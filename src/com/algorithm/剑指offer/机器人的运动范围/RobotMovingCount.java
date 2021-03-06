package com.algorithm.剑指offer.机器人的运动范围;

/**
 * create by Ernest on 2020/2/23.
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 回溯法
 */
public class RobotMovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        return process(0, 0, rows, cols, dp, threshold);
    }

    private int process(int i, int j, int rows, int cols, int[][] dp, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols
                || sum(i) + sum(j) > threshold || dp[i][j] == 1) {
            return 0;
        }
        dp[i][j] = 1;
        return 1 + process(i - 1, j, rows, cols, dp, threshold)
                 + process(i + 1, j, rows, cols, dp, threshold)
                 + process(i, j - 1, rows, cols, dp, threshold)
                 + process(i, j + 1, rows, cols, dp, threshold);
    }


    private int sum(int value) {
        int sum = 0;
        while (value != 0) {
            sum += value % 10;
            value = value / 10;
        }
        return sum;
    }

}
