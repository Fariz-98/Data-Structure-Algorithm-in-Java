package study.java.datastructure.algo.leetcode;

import study.java.datastructure.algo.leetcode.datastructure.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        if (root != null) {
            integerList.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder(root.children.get(i));
            }
        }
        return integerList;
    }

}
