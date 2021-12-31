package study.java.datastructure.algo.leetcode.leetcode50;

// 124
// Hard

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {

    int res = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        // Find max sum with split (For every parent, once the child is calculated, we also need to look at the value
        // without splitting)
        res = Math.max(res, root.val + left + right);
        // Return one maximum path either left or right so that we can find one continuous path from parent to the
        // max depth (Calculate without split).
        return root.val + Math.max(left, right);
    }

}
