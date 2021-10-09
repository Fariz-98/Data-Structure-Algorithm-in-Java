package study.java.datastructure.algo.leetcode;

// 21
// Easy

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1a = new ListNode(2);
        ListNode l1b = new ListNode(4);
        l1.next = l1a;
        l1a.next = l1b;

        ListNode l2 = new ListNode(1);
        ListNode l2a = new ListNode(3);
        ListNode l2b = new ListNode(4);
        l2.next = l2a;
        l2a.next = l2b;

        ListNode mergedList = mergeTwoLists(l1, l2);
        displayList(mergedList);
    }

    public static void displayList(ListNode listNode) {
        ListNode ptr = listNode;

        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;

        if (l1 == null) {
            while (l2 != null) {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
            return head.next;
        } else if (l2 == null) {
            while (l1 != null) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
            return head.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1; // current.next is used here because if current = l1 is used, it will only change the address of current, not the head list value.
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }
        } else {
            while (l2 != null) {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }

        return head.next;
    }
}




class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
