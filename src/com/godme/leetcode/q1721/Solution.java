package com.godme.leetcode.q1721;


class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head, right = head;
        // 拉开间隔尺
        for(int index = 1; index < k; index++){
            right = right.next;
        }
        // 此时right为第一个节点
        ListNode leftNode = right;
        // 遍历到末尾
        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        // 此时left为第二个节点
        // 连接关系无特殊要求，交换值即可
        int val = leftNode.val;
        leftNode.val = left.val;
        left.val = val;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
