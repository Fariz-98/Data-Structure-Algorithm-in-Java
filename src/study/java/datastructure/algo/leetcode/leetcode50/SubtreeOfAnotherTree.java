package study.java.datastructure.algo.leetcode.leetcode50;

// 572
// Easy

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null && subRoot != null) {
            return false;
        }

        if (isSame(root, subRoot)) {
            return true;
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root != null && subRoot != null && (root.val == subRoot.val)) {
            return (isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right));
        }

        return false;
    }

}
