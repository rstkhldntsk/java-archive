package com.leetcode.archive.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board[i]) || !isValidCol(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(char[] row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (row[i] != '.' && !set.add(row[i])) return false;
        }
        return true;
    }

    private static boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && !set.add(board[i][col])) return false;
        }
        return true;
    }

    private static boolean isValidBox(char[][] board, int box) {
        Set<Character> set = new HashSet<>();
        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }
        }
        return true;
    }

}
