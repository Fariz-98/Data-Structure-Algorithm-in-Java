package study.java.datastructure.algo.leetcode;

// 237
// Easy
// The question is to delete a node without being given a head which is why changing the value is required.

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
