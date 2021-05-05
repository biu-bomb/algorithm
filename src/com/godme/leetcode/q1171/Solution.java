package com.godme.leetcode.q1171;

import java.util.HashMap;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        // 每个节点的和直接累加并存储
        for(ListNode cursor = dummy; cursor!=null; cursor = cursor.next){
            sum += cursor.val;
            map.put(sum, cursor);
        }
        sum = 0;
        // 如果出现了相同的和
        //  1. 当前节点
        //  2. 两个节点之间和为0
        for(ListNode cursor = dummy; cursor!=null; cursor = cursor.next){
            sum += cursor.val;
            cursor.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
