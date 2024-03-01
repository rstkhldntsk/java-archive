package com.leetcode.archive.medium;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];
        visitedRooms[0] = true;
        Stack<Integer> keys = new Stack<>();
        keys.push(0);
        while (!keys.isEmpty()) {
            int key = keys.pop();
            List<Integer> room = rooms.get(key);
            for (int keyInRoom : room) {
                if (!visitedRooms[keyInRoom]) {
                    visitedRooms[keyInRoom] = true;
                    keys.push(keyInRoom);
                }
            }
        }

        for (boolean visitedRoom : visitedRooms) if (!visitedRoom) return false;
        return true;
    }

}
