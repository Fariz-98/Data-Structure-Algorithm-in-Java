package study.java.datastructure.algo.leetcode.leetcode50;

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        ListNode deletedList = removeNthFromEnd(list1, 5);
        ListNode current = deletedList;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // Have a toDelete, beforeDelete and current pointer
        // the toDelete will move after n pass
        // the beforeDelete will move after n + 1 pass (because we will change this.next to toDelete.next)
        // the current will move first

        ListNode toDelete = head;
        ListNode beforeDelete = head;
        ListNode current = head;
        int pass = 0;

        while (current != null) {
            if (pass < n) {
                // Check if it's deleting the first node
                if (current.next == null) {
                    ListNode next = head.next;
                    head.next = null;
                    return next;
                }
                current = current.next;
                pass++;
            } else if (pass == n) {
                current = current.next;
                toDelete = toDelete.next;
                pass++;
            } else {
                current = current.next;
                toDelete = toDelete.next;
                beforeDelete = beforeDelete.next;
            }
        }

        beforeDelete.next = toDelete.next;
        return head;
    }

}
