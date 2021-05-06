package com.godme.leetcode.q817;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> members = new HashSet<>();
        for(int value: G){
            members.add(value);
        }
        int subset = 0, store;
        while(!members.isEmpty() && head != null){
            if(members.contains(head.val)){
                subset += 1;
                while (head != null && members.contains(head.val)){
                    members.remove(head.val);
                    head = head.next;
                }
            }
            head = head == null ? null: head.next;
        }
        return subset;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
