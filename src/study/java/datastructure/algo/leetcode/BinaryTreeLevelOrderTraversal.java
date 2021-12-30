package study.java.datastructure.algo.leetcode;

// 102
// Medium

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        for (List<Integer> tempList : levelOrder(root)) {
            for (int tempInt : tempList) {
                System.out.print(tempInt + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int length = q.size();
            List<Integer> currList = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode curr = q.remove();
                currList.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (!currList.isEmpty()) {
                res.add(currList);
            }
        }

        return res;
    }


}
