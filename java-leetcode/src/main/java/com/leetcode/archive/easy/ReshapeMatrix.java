package com.leetcode.archive.easy;

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int[][] matRes = new int[r][c];
        int rows = 0;
        int cols = 0;
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                matRes[rows][cols] = mat[i][j];
                cols++;
                if (cols == c) {
                    cols = 0;
                    rows++;
                }
            }
        }
        return matRes;
    }

}
