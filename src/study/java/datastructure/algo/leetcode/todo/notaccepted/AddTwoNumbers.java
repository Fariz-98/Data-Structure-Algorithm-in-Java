package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 2
// Medium

import study.java.datastructure.algo.leetcode.datastructure.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Calculate total value for each node and add to sum
        int total = totalValue(l1) + totalValue(l2);

        // Reverse total, add to new linked list
        ListNode head = new ListNode();
        ListNode current = head;

        String stringTotal = String.valueOf(total);
        for (int i = stringTotal.length() - 1; i >= 0; i--) {
            current.val = Integer.parseInt(String.valueOf(stringTotal.charAt(i)));

            if (i == 0) {
                break;
            }

            current.next = new ListNode();
            current = current.next;
        }

        return head;
    }

    public int totalValue(ListNode node) {
        ListNode current = node;
        StringBuilder strBuilder = new StringBuilder();
        while (current != null) {
            strBuilder.append(current.val);
            current = current.next;
        }

        return Integer.parseInt(strBuilder.toString());
    }

}
