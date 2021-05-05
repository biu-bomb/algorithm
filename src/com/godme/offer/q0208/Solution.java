package com.godme.offer.q0208;


public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        do{
            fast = fast == null?null:fast.next;
            fast = fast == null?null:fast.next;
            slow = slow.next;
        }while (fast != slow);
        if(fast == null){
            return null;
        }
        while (head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
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

