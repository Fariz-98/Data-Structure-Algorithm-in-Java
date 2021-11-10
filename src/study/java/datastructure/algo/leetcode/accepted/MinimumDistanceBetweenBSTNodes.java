package study.java.datastructure.algo.leetcode.accepted;

// 783
// Easy

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    static Integer difference = Integer.MAX_VALUE;
    static Integer diffTemp = Integer.MAX_VALUE;
    static Integer previousNodeVal = null;

    public static void main(String[] args) {

    }

    public static int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);

            if (previousNodeVal != null) {
                diffTemp = root.val - previousNodeVal;
                if (diffTemp <= difference)
                    difference = diffTemp;
            }

            previousNodeVal = root.val;

            minDiffInBST(root.right);
        }
        return difference;
    }

    public static int minDiffInBSTList(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();

        inOrderTraverseList(root, inOrderList);

        int minimum = Integer.MAX_VALUE;
        int difference;

        for (int i = 0; i < inOrderList.size(); i++) {
            if (i == inOrderList.size() - 1) {
                break;
            }

            difference = inOrderList.get(i + 1) - inOrderList.get(i);
            if (difference <= minimum)
                minimum = difference;
        }
        return minimum;
    }

    public static void inOrderTraverseList(TreeNode focusNode, List<Integer> inOrderList) {
        if (focusNode != null) {
            inOrderTraverseList(focusNode.left, inOrderList);

            inOrderList.add(focusNode.val);

            inOrderTraverseList(focusNode.right, inOrderList);
        }
    }

}
