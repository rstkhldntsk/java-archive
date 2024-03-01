package com.leetcode.hashing;

import java.util.HashSet;

/**
 * 36. Valid Sudoku(medium)
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i]) || !isValidColumn(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidRow(char[] row) {
        var set = new HashSet<Character>();
        for (char c : row) {
            if (c != '.' && !set.add(c)) return false;
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int column) {
        var set = new HashSet<Character>();
        for (char[] row : board) {
            if (row[column] != '.' && !set.add(row[column])) return false;
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int box) {
        var set = new HashSet<Character>();
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
