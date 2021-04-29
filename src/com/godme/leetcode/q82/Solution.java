package com.godme.leetcode.q82;


class Solution {
    // 递归: 去除头节点重复
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int detector = head.val;
        // 如果头节点有重复，返回非当前重复值的后续节点，递归剔除非连续重复
        if(head.next.val == detector){
            // 找第一个非重复节点
            while(head != null && head.val == detector){
                head = head.next;
            }
            // 递归
            return deleteDuplicates(head);
        }
        // 当前头不重复，拼接后续头不重复链表
        head.next = deleteDuplicates(head.next);
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
