package com.godme.leetcode.q25;

import com.godme.leetcode.q21.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1){
            return head;
        }
       ListNode cursor = head;
        for (int i = 0; i < k - 1; i++) {
            if(cursor == null){
                return head;
            }
            cursor = cursor.next;
        }
        if(cursor == null){
            return head;
        }
        ListNode next = cursor.next;
        cursor.next = null;
        // 翻转头
        ListNode hc,h = reverseNode(head);
        hc = h.next;
        while (hc.next != null){
            hc = hc.next;
        }
        // 递归后续
        hc.next = reverseKGroup(next, k);
        return h;
    }
    // 翻转
    public ListNode reverseNode(ListNode origin){
        return reverseNode(origin, null);
    }
    // 递归翻转
    public ListNode reverseNode(ListNode origin, ListNode reverse){
        if(origin == null){
            return reverse;
        }
        ListNode next = origin.next;
        origin.next = reverse;
        return reverseNode(next, origin);
    }


    public static void main(String[] args) {
        System.err.println(new Solution().reverseKGroup(ListNode.fromNums(1,2,3,4,5), 1));
    }
}