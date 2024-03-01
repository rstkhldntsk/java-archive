package com.leetcode.archive.medium;

public class NumberOfIslands {

    char[][] grid;
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count += dfs(r, c);
                }
            }
        }
        return count;
    }

    private int dfs(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == '0') return 0;
        seen[r][c] = true;
        dfs(r - 1,c);
        dfs(r + 1,c);
        dfs(r ,c + 1);
        dfs(r ,c - 1);
        return 1;
    }

}
