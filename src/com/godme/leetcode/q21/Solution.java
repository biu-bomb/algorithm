package com.godme.leetcode.q21;


public class Solution {
    // 单链表的头不稳定，轻易截断与后续的关联
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode a = ListNode.fromNums(-10, -9, -6, -4, 1, 9, 9);
        ListNode b = ListNode.fromNums(-5, -3, 0, 7, 8, 8);
        Solution solution = new Solution();
        System.err.println(solution.mergeTwoLists(a, b));
    }
}
