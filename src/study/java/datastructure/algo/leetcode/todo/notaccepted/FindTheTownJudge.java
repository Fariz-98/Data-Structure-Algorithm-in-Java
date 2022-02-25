package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 997
// Easy

import java.util.*;

public class FindTheTownJudge {

    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        // Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] tempArr : trust) {
            List<Integer> trusted = graph.get(tempArr[0]);
            trusted.add(tempArr[1]);
        }

        Set<Integer> visited = new HashSet<>();
        // Find if there is a cycle, no judge exists, else, judge exist.
        for (int i = 1; i <= n; i++) {
            if (!DFS(graph, visited, i)) {
                return -1;
            }
        }

        return n;
    }

    public boolean DFS(Map<Integer, List<Integer>> graph, Set<Integer> visited, int i) {
        if (visited.contains(i)) {
            return false;
        }

        if (graph.get(i).isEmpty()) {
            return true;
        }

        visited.add(i);
        if (!DFS(graph, visited, graph.get(i).get(0))) {
            return false;
        }

        visited.remove(i);
        return true;
    }

}


























