package com.leetcode.archive.medium;

public class MinimumDominoRotation {

    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Math.min(
                rotationHelper(tops[0], tops, bottoms),
                rotationHelper(bottoms[0], tops, bottoms)
        );
        res = Math.min(res, rotationHelper(tops[0], bottoms, tops));
        res = Math.min(res, rotationHelper(bottoms[0], bottoms, tops));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int rotationHelper(int elem, int[] tops, int[] bottoms) {
        int count = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != elem && bottoms[i] == elem) count++;
            else if (tops[i] != elem && tops[i] != elem) return Integer.MAX_VALUE;
        }
        return count;
    }

}
