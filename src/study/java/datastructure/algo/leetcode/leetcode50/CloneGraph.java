package study.java.datastructure.algo.leetcode.leetcode50;

// 133
// Medium

import study.java.datastructure.algo.leetcode.datastructure.GraphNode;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {

    }

    public GraphNode cloneGraph(GraphNode GraphNode) {
        List<GraphNode> visited = new ArrayList<>();
        List<Integer> visitedVal = new ArrayList<>();
        Map<Integer, GraphNode> visitedMap = new HashMap<>();
        return cloneUsingMap(GraphNode, visitedMap);
    }

    public GraphNode cloneUsingMap(GraphNode root, Map<Integer, GraphNode> visited) {
        if (root == null) {
            return null;
        }

        if (visited.containsKey(root.val)) {
            return visited.get(root.val);
        }

        GraphNode res = new GraphNode(root.val);
        visited.put(root.val, res);
        List<GraphNode> resNeighbors = new ArrayList<>();

        for (GraphNode tempGraph : root.neighbors) {
            resNeighbors.add(cloneUsingMap(tempGraph, visited));
        }

        res.neighbors = resNeighbors;
        return res;
    }

    public GraphNode cloneUsingTwoLists(GraphNode root, List<GraphNode> visited, List<Integer> visitedVal) {
        if (root == null) {
            return null;
        }

        if (visitedVal.contains(root.val)) {
            for (GraphNode tempGraphNode : visited) {
                if (tempGraphNode.val == root.val) {
                    return tempGraphNode;
                }
            }
        }

        GraphNode res = new GraphNode(root.val);
        visited.add(res);
        visitedVal.add(root.val);
        List<GraphNode> resNeighbors = new ArrayList<>();

        for (GraphNode tempGraph : root.neighbors) {
            GraphNode newGraphNode = cloneUsingTwoLists(tempGraph, visited, visitedVal);
            resNeighbors.add(newGraphNode);
        }

        res.neighbors = resNeighbors;
        return res;
    }

}
