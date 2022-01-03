package study.java.datastructure.algo.leetcode.leetcode50;

// 23
// Hard

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] list = new ListNode[1];
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(5);
        first.next = second;
        second.next = third;

        list[0] = first;

        ListNode curr = mergeKLists(list);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Integer::compare);

        // Fill the heap with lists value
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];

            while (curr != null) {
                heap.add(curr.val);
                curr = curr.next;
            }
        }

        ListNode head = new ListNode();
        ListNode curr = head;

        while (true) {
            curr.val = heap.remove();

            if (heap.isEmpty()) {
                break;
            }

            curr.next = new ListNode();
            curr = curr.next;
        }

        return head;
    }

}
