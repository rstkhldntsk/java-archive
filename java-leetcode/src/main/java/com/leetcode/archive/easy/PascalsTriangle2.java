package com.leetcode.archive.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            list = countNextRow(list);
        }
        return list;
    }

    private List<Integer> countNextRow(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            newList.add(list.get(i) + list.get(i + 1));
        }
        newList.add(1);
        return newList;
    }

}
