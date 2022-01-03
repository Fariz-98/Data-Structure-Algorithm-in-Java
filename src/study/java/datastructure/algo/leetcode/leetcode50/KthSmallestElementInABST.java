package study.java.datastructure.algo.leetcode.leetcode50;

// 240
// Medium

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;


public class KthSmallestElementInABST {

    int count = 0;
    int res = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || res != Integer.MIN_VALUE) {
            return;
        }

        inOrder(root.left, k);

        count++;

        if (count == k) {
            res = root.val;
            return;
        }

        inOrder(root.right, k);
    }

}
