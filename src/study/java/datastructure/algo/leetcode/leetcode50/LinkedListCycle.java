package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

// 141
// Easy

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = second;

        System.out.println(hasCycle(first));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode normal = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            normal = normal.next;

            if (fast == normal) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycleSet(ListNode head) {
        Set<ListNode> tracker = new HashSet<>();

        ListNode current = head;

        while (true) {
            if (current == null) {
                return false;
            }

            if (!tracker.add(current)) {
                return true;
            }

            current = current.next;
        }
    }

}
