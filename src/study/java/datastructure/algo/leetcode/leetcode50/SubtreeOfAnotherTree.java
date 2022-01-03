package study.java.datastructure.algo.leetcode.leetcode50;

// 572
// Easy

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {

    public boolean hasSubTree = false;

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root, subRoot);
        return hasSubTree;
    }

    public void dfs(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
            hasSubTree = false;
            return;
        } else if (root == null && subRoot == null) {
            return;
        }

        if (root.val == subRoot.val) {
            hasSubTree = true;
            dfs(root.left, subRoot.left);

            if (hasSubTree) {
                dfs(root.right, subRoot.right);
            }
        } else {
            hasSubTree = false;
        }

        if (!hasSubTree) {
            dfs(root.left, subRoot);
        }

        if (!hasSubTree) {
            dfs(root.right, subRoot);
        }
    }

}
