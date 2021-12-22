package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        TreeNode root = builder(inorder, 0, inorder.length - 1,
//                preorder, 0, preorder.length - 1);

        // Optimization: Put all inorder values in a map so that to find the preorder index, we don't have to loop over it
        // THIS WILL ONLY WORK IF ALL THE VALUES ARE UNIQUE.
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = builderOptimized(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1,
                inorderMap);

        return root;
    }

    // Divide into sub-tree, first, take preorder[start] as root, find the preorder[start] number in inorder.
    // The left of that index is the left subtree, the right of that index is the right subtree because inorder = LEFT ROOT RIGHT
    // Create the root.left passing inorder from 0 to preorder[start] number and preorder from start + 1 to the end.
    // Create the root.right passing inorder from preorder[start] index + 1 to the end and preorder from start + left number count of inorder start index to the end.

    public static TreeNode builder(int[] inorder, int inorderStart, int inorderEnd,
                                   int[] preorder, int preorderStart, int preorderEnd) {
        // Base case = if preOrder or inOrder has ran out of number (start index > end index) that means the children is null
        if (inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }

        // Set the root to the start value of preorder index
        TreeNode root = new TreeNode(preorder[preorderStart]);

        // Find the index of root in inorder
        int rootInInorder = 0;
        for (int i = inorderStart; i < inorder.length; i++) {
            if (inorder[i] == preorder[preorderStart])
                rootInInorder = i;
        }
        // This will be used to get our next preorder value for our right sub-tree
        // and preorder end for our left sub-tree
        int numberCountOnTheLeft = rootInInorder - inorderStart;

        // Build left sub-tree
        root.left = builder(inorder, inorderStart, rootInInorder - 1,
                preorder, preorderStart + 1, preorderStart + numberCountOnTheLeft);
        // Build right sub-tree
        root.right = builder(inorder, rootInInorder + 1, inorderEnd,
                preorder, preorderStart + numberCountOnTheLeft + 1, preorderEnd);

        return root;
    }

    public static TreeNode builderOptimized(int[] inorder, int inorderStart, int inorderEnd,
                                            int[] preorder, int preorderStart, int preorderEnd,
                                            Map<Integer, Integer> inOrderMap) {
        // Base case
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        // Set the root
        TreeNode root = new TreeNode(preorder[preorderStart]);

        // Find the root index in inorder
        int rootInOrder = inOrderMap.get(preorder[preorderStart]);
        int leftCounter = rootInOrder - inorderStart;

        // Build left sub-tree
        root.left = builderOptimized(inorder, inorderStart, rootInOrder - 1,
                preorder, preorderStart + 1, leftCounter + preorderStart, inOrderMap);
        // Build right sub-tree
        root.right = builderOptimized(inorder, rootInOrder + 1, inorderEnd,
                preorder, preorderStart + leftCounter + 1, preorderEnd, inOrderMap);

        return root;
    }

}
