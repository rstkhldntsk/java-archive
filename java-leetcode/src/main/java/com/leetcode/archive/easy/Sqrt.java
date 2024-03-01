package com.leetcode.archive.easy;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        for (long i = 2; i <= x; i++) {
            if (i * i == x) {
                return (int) i;
            } else if (i * i > x) {
                return (int) i - 1;
            }
        }
        return 1;
    }

}
