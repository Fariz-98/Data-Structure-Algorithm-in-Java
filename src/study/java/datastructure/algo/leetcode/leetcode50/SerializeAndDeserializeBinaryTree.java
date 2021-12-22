package study.java.datastructure.algo.leetcode.leetcode50;

// 297
// Hard

import study.java.datastructure.algo.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootRightLeft = new TreeNode(4);
        TreeNode rootRightRight = new TreeNode(5);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left =rootRightLeft;
        rootRight.right = rootRightRight;

        System.out.print("Original Tree: ");
        System.out.println(serializeBFS(root));

        String originalTreeSer = serializeBFS(root);
        TreeNode s = deserializeBFS(originalTreeSer);
        System.out.println();
        System.out.print("Deserialied tree: ");
        System.out.println(serializeBFS(s));

    }

    public static String serializeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Serialize will be done using BFS(Level order traversal) and the delimiter will be a comma (",")
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            if (current == null) {
                res.append("N").append(",");
                continue;
            }

            res.append(current.val).append(",");
            q.add(current.left);
            q.add(current.right);
        }

        // Delete null at the end
        int i = res.length() - 1;
        while (true) {
            if (res.charAt(i) == ',' || res.charAt(i) == 'N') {
                res.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }

        return res.toString();
    }

    public static TreeNode deserializeBFS(String data) {
        if (data == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] splitData = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splitData[0]));
        q.add(root);

        for (int i = 1; i < splitData.length; i += 2) {
            TreeNode curr = q.poll();

            // Left tree
            if (!splitData[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(splitData[i]));
                curr.left = left;
                q.add(left);
            }

            // Right tree
            if (i + 1 < splitData.length && !splitData[i + 1].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(splitData[i + 1]));
                curr.right = right;
                q.add(right);
            }
        }

        return root;
    }

}






















