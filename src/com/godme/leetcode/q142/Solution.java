package com.godme.leetcode.q142;


public class Solution {
    // 2 * s_slow = s_fast
    // 2(a+b) = a + n(b+c) + b
    // a = c + (n-1)(b+c) : 分别从相遇点和头结点触发，最终会在入环点相遇
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (head != slow){
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

