package com.leetcode.archive.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextRow = calculateNextRow(res.get(i - 1));
            res.add(nextRow);
        }
        return res;
    }

    private List<Integer> calculateNextRow(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            newList.add(list.get(i) + list.get(i + 1));
        }
        newList.add(1);
        return newList;
    }

}
