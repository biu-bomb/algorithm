package com.godme.leetcode.q61;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null|| head.next == null ){
            return head;
        }
        int size = 1;
        ListNode cursor;
        // 遍历一遍，确定长度
        for (cursor = head;cursor.next != null;size++){
            cursor = cursor.next;
        }
        // 消除旋转周期
        if((k = k % size) == 0){
            return head;
        }
        // 构建环形链表，并正向旋转size-k-1，找到新头结点的前一个接地单
        for(cursor.next = head, k=size - k - 1; k > 0; k--){
            head = head.next;
        }
        ListNode result = head.next;
        // 解除循环
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.err.println(new Solution().rotateRight(node, 4));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
