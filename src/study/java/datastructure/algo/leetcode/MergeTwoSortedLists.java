package study.java.datastructure.algo.leetcode;

// 21
// Easy

import study.java.datastructure.algo.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l1a = new ListNode(2);
//        ListNode l1b = new ListNode(4);
//        l1.next = l1a;
//        l1a.next = l1b;

        ListNode l2 = new ListNode(2);
//        ListNode l2a = new ListNode(3);
//        ListNode l2b = new ListNode(4);
//        l2.next = l2a;
//        l2a.next = l2b;

        ListNode mergedList = mergeTwoListUsingListUsingVal(l1, l2);
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

    public static ListNode mergeTwoListUsingList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        List<Integer> numList = new ArrayList<>();
        while (l1 != null) {
            numList.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            numList.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(numList);
        Iterator<Integer> itr = numList.iterator();

        ListNode mergedList = new ListNode();
        ListNode current = mergedList;
        boolean firstInsert = true;

        while (itr.hasNext()) {
            Integer next = itr.next();
            if (!itr.hasNext()) { // If it's the last value
                current.val = next;
                break;
            }
            if (firstInsert) {
                current.val = next;
                current.next = new ListNode();
                current = current.next;
                firstInsert = false;
            } else {
                current.val = next;
                current.next = new ListNode();
                current = current.next;
            }

        }

        return mergedList;
    }

    public static ListNode mergeTwoListUsingListUsingVal(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode mergedList = new ListNode();
        ListNode current = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (l1.next == null) {
                    current.val = l1.val;
                    current.next = new ListNode();
                    current = current.next;
                    l1 = l1.next;
                    break;
                }
                current.val = l1.val;
                l1 = l1.next;
            } else {
                if (l2.next == null) {
                    current.val = l2.val;
                    current.next = new ListNode();
                    current = current.next;
                    l2 = l2.next;
                    break;
                }
                current.val = l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode();
            current = current.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                if (l1.next == null) {
                    current.val = l1.val;
                    break;
                }
                current.val = l1.val;
                l1 = l1.next;
                current.next = new ListNode();
                current = current.next;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                if (l2.next == null) {
                    current.val = l2.val;
                    break;
                }
                current.val = l2.val;
                l2 = l2.next;
                current.next = new ListNode();
                current = current.next;
            }
        }
        return mergedList;
    }

}

