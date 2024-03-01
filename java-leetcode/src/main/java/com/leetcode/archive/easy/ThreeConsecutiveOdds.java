package com.leetcode.archive.easy;

public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
//        for (int i = 0; i < arr.length - 2; i++) {
//            if (arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1) {
//                return true;
//            }
//        }
//        return false;
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) cnt = 0;
            else if (++cnt == 3) return true;
        }
        return false;
    }

}
