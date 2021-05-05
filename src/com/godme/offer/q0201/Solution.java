package com.godme.offer.q0201;


import java.util.HashSet;

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(-1), cursor = dummy;
        dummy.next = head;
        HashSet<Integer> cache = new HashSet<>();
        while (cursor.next != null){
            while(cursor.next != null && cache.contains(cursor.next.val)){
                cursor.next = cursor.next.next;
            }
            if(cursor.next != null){
                cache.add(cursor.next.val);
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

