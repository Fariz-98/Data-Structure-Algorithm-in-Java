package study.java.datastructure.algo.leetcode.accepted;

// 83
// Easy

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(2);
//        ListNode fourth = new ListNode(3);
//        ListNode fifth = new ListNode(3);
//        fifth.next = null;

        first.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;

        ListNode newList = deleteDuplicates(first);
        displayList(newList);
    }

    public static ListNode deleteDuplicatesUsingNewList(ListNode head) {
        ListNode headPtr = head;
        ListNode newList = new ListNode();
        ListNode ptr = newList;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        while (true) {
            if (headPtr == null) {
                break;
            }

            if (headPtr.next != null && headPtr.val == headPtr.next.val) {
                headPtr = headPtr.next;
                continue;
            }

            ptr.next = headPtr;
            ptr = ptr.next;
            headPtr = headPtr.next;
        }

        return newList.next;
    }

    // TODO: Solve this without creating another list.
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        while (true) {
            if (ptr == null) {
                break;
            }

            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            }
            ptr = ptr.next;
        }

        return head;
    }


    public static void displayList(ListNode listNode) {
        ListNode ptr = listNode;

        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }

}