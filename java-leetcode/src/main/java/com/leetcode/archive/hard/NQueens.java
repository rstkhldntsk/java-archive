package com.leetcode.archive.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The isValid method is used to check whether a queen can be placed on a certain spot on the board without conflicting with any other queens.
 * The backtracking algorithm starts by placing a queen in the first row and first column,
 * then proceeds to the next row and checks all possible columns in that row.
 * If a column is not valid, the algorithm backtracks and tries a different column.
 * This process is repeated until all queens have been placed on the board or all possible combinations have been exhausted.
 * The final result is a List of List of String, where each list of string represents a valid solution,
 * each string representing a row and Q representing a Queen.
 */
public class NQueens {

    private List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, 0);
        return solutions;
    }

    private void backtrack(int[] queens, int row) {
        if (row == queens.length) {
            addSolution(queens);
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, row + 1);
                queens[row] = -1;
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || (row -i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(int[] queens) {
        List<String> solution = new ArrayList<>();
        for (int queen : queens) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queen == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        solutions.add(solution);
    }

}
