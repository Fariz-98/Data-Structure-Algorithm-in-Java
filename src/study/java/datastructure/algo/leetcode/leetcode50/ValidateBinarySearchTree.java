package study.java.datastructure.algo.leetcode.leetcode50;

// 98
// Medium

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    Boolean res = true;
    TreeNode prev = null;

    public static void main(String[] args) {
//        TreeNode parent = new TreeNode(2);
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(3);
//        parent.left = left;
//        parent.right = right;

        TreeNode parent = new TreeNode(5);
        TreeNode parentLeft = new TreeNode(4);
        TreeNode parentRight = new TreeNode(6);
        TreeNode parentRightLeft = new TreeNode(3);
        TreeNode parentRightRight = new TreeNode(7);

        parent.left = parentLeft;
        parent.right = parentRight;
        parentLeft.left = null;
        parentLeft.right = null;
        parentRight.left = parentRightLeft;
        parentRight.right = parentRightRight;


        // 5,4,6,null,null,3,7

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean test = validateBinarySearchTree.isValidBST(parent);
        System.out.println(test);
    }

    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        return res;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null || !res) {
            return;
        }

        inOrderTraversal(root.left);

        if (prev != null && prev.val >= root.val) {
            res = false;
            return;
        }
        prev = root;

        inOrderTraversal(root.right);
    }

}






















