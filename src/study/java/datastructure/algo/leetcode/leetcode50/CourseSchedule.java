package study.java.datastructure.algo.leetcode.leetcode50;

// 207
// Medium

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create the graph for the courses and pre-req
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        for (int[] tempArr : prerequisites) {
            List<Integer> preReqList = graphMap.get(tempArr[0]);
            preReqList.add(tempArr[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> courseAbleToComplete = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!DFS(graphMap, visited, i, courseAbleToComplete)) {
                return false;
            }
        }

        return true;
    }

    public static boolean DFS(Map<Integer, List<Integer>> graphMap, Set<Integer> visited, int course, Set<Integer> courseAbleToComplete) {
        if (visited.contains(course)) {
            return false;
        }

        if (graphMap.get(course) == null || courseAbleToComplete.contains(course)) {
            return true;
        }

        visited.add(course);
        for (Integer tempCourse : graphMap.get(course)) {
            if (!DFS(graphMap, visited, tempCourse, courseAbleToComplete)) {
                return false;
            }
        }

        visited.remove(course);
        courseAbleToComplete.add(course);
        return true;
    }

}









































