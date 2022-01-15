package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    boolean hasP = false;
    boolean hasQ = false;
    TreeNode res;

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (true) {
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
    }

    public TreeNode lowestCommonAncestorInitial(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return res;
        }

        // For each node, check its children for p and q
        // If parent == p || q, check p || q value in children
        if (root.val == p.val) {
            hasP = true;
            hasQ = DFS(root, q);
        } else if(root.val == q.val) {
            hasQ = true;
            hasP = DFS(root, p);
        } else {
            hasP = DFS(root, p);
            hasQ = DFS(root, q);
        }

        if (hasP && hasQ) {
            res = root;
        }

        hasP = false;
        hasQ = false;

        lowestCommonAncestorInitial(root.left, p, q);
        lowestCommonAncestorInitial(root.right, p, q);

        return res;
    }

    public boolean DFS(TreeNode root, TreeNode toFind) {
        if (root == null) {
            return false;
        }

        if (root.val == toFind.val) {
            return true;
        }

        return DFS(root.left, toFind) || DFS(root.right, toFind);
    }

}
