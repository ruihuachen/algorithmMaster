package com.algorithm.力扣问题.判断是否为2次方;
import java.util.*;

/**
 * 2的幂次方问题&比特数计数问题
 *
 * leetcode[231]
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

    public static boolean isSecondaryPower(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

}
