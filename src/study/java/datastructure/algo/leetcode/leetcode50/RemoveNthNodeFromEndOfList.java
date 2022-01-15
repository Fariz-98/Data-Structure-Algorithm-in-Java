package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

// 19
// Medium

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;

        ListNode current = removeNthFromEnd(list1, 2);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        // Have 2 pointer, current and beforeDelete
        // the beforeDelete will move after n + 1 pass (because we will change this.next to this.next.next)
        ListNode beforeDelete = head;
        ListNode current = head;
        int pass = 0;

        while (current != null) {
            if (pass <= n) {
                current = current.next;
                pass++;
            } else {
                current = current.next;
                beforeDelete = beforeDelete.next;
            }
        }

        if (pass == n) {
            return head.next;
        } else {
            beforeDelete.next = beforeDelete.next.next;
            return head;
        }
    }

}
