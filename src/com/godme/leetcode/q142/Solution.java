package com.godme.leetcode.q142;


public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head.next, fast = head.next.next;
        while(fast != null && fast.next != null && fast != slow){
            System.out.println(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null || fast.next == null) return null;
        while(head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = ListNode.fromNums(1,2,3);
        System.err.println(solution.detectCycle(node));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    static ListNode fromNums(int ...nums){
        ListNode listNode = null, cursor = null;
        for(int num: nums){
            if(listNode == null){
                cursor = listNode = new ListNode(num);
            } else {
                cursor.next = new ListNode(num);
                cursor = cursor.next;
            }
        }
        return listNode;
    }
}

