package com.leetcode.archive.medium;

public class RotateImage {

    public static void main(String[] args) {
        int[][] originalArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] originalArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int[] row : originalArray) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }

        System.out.println("------");

        rotate(originalArray);

        for (int[] row : originalArray) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] arr) {
        transpose(arr);
        flipHorizontally(arr);
    }

    private static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }
    }

    private static void flipHorizontally(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][arr[j].length - 1 - j];
                arr[i][arr[j].length - 1 - j] = tmp;
            }
        }
    }

}
