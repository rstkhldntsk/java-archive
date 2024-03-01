package com.leetcode.archive.easy;

import java.util.*;

public class Solution {

    public static String[][] findPairs(String[][] enrollments) {
        Map<String, Set<String>> courseMap = new HashMap<>();

        // Build a map of courses for each student
        for (String[] enrollment : enrollments) {
            String studentId = enrollment[0];
            String course = enrollment[1];

            if (!courseMap.containsKey(studentId)) {
                courseMap.put(studentId, new HashSet<>());
            }

            courseMap.get(studentId).add(course);
        }

        // Find shared courses between pairs of students
        List<String[]> result = new ArrayList<>();
        List<String> studentIds = new ArrayList<>(courseMap.keySet());
        int n = studentIds.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String studentId1 = studentIds.get(i);
                String studentId2 = studentIds.get(j);
                Set<String> courses1 = courseMap.get(studentId1);
                Set<String> courses2 = courseMap.get(studentId2);

                Set<String> sharedCourses = new HashSet<>(courses1);
                sharedCourses.retainAll(courses2);

                String[] pair = new String[]{studentId1 + "," + studentId2, sharedCourses.toString()};
                result.add(pair);
            }
        }

        // Convert the result to String[][]
        String[][] output = new String[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            output[i][0] = result.get(i)[0];
            output[i][1] = result.get(i)[1];
        }

        return output;
    }

    public static void main(String[] argv) {
        String[][] enrollments1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };

        String[][] enrollments2 = {
                {"0", "Advanced Mechanics"},
                {"0", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };

        String[][] enrollments3 = {
                {"23", "Software Design"},
                {"3", "Advanced Mechanics"},
                {"2", "Art History"},
                {"33", "Another"},
        };

        String[][] sharedCourses = findPairs(enrollments1);

        // Print the output
        for (String[] pair : sharedCourses) {
            System.out.println(pair[0] + ": " + pair[1]);
        }

    }

}
