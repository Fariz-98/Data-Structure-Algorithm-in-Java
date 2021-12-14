package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 226
// Easy

public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            if (curr.left != null && curr.right != null) {
                TreeNode tempNode = curr.left;
                curr.left = curr.right;
                curr.right = tempNode;
            } else if (curr.left == null && curr.right != null) {
                curr.left = curr.right;
                curr.right = null;
            } else if (curr.right == null && curr.left != null) {
                curr.right = curr.left;
                curr.left = null;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return root;
    }

}
