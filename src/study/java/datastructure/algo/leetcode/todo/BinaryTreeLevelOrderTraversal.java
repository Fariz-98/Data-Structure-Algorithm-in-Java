package study.java.datastructure.algo.leetcode.todo;

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TODO:
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returning = new ArrayList<>();

//        levelOrderTraversal(returning, root);

        return returning;
    }

    public static void levelOrderTraversal(List<List<Integer>> listToAdd, TreeNode root, List<Integer> prevList) {
        List<Integer> currList = new ArrayList<>();
        currList.add(root.val);
        levelOrderTraversal(listToAdd, root.left, prevList);
        levelOrderTraversal(listToAdd, root.right, prevList);
        currList.add(root.val);
        listToAdd.add(currList);
    }

}
