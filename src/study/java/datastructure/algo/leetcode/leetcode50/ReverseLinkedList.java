package study.java.datastructure.algo.leetcode.leetcode50;

// 206
// Easy

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode scnd = new ListNode(2);
        ListNode thrd = new ListNode(3);
        ListNode frth = new ListNode(4);
        ListNode ffth = new ListNode(5);

        head.next = scnd;
        scnd.next = thrd;
        thrd.next = frth;
        frth.next = ffth;
        ffth.next = null;

        ListNode curr = reverseLit(head);
        while (true) {
            System.out.println(curr.val);
            curr = curr.next;

            if (curr == null) {
                break;
            }
        }
    }

    public static ListNode reverseLit(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode current = head.next;
        ListNode holder = head.next.next;
        head.next = null;

        while (true) {
            current.next = prev;

            if (holder == null) {
                return current;
            }

            prev = current;
            current = holder;
            holder = holder.next;
        }
    }

}
