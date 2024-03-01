package com.leetcode.archive.medium;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int next;
        int[] stack = new int[temperatures.length];
        int[] answer = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            next = i + 1;
            while (next < temperatures.length && temperatures[next] <= temperatures[i])
                next = stack[next];
            stack[i] = next;
            if (next != temperatures.length)
                answer[i] = next - i;
        }
        return answer;
    }

}
