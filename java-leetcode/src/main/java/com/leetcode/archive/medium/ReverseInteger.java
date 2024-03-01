package com.leetcode.archive.medium;

public class ReverseInteger {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            res = res * 10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120)); // 21
    }

}
