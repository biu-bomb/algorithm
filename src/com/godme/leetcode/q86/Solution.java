package com.godme.leetcode.q86;


class Solution {
    //  1. 分别找到小数插入点和大数查找点
    //  2. 查找大数的下一个节点
    //      2.1 如果不存在下一个节点，返回小数头节点
    //      2.1 如果是大数，返回步骤2继续执行
    //      2.2 如果是小数，弹出下一个节点，插入小数插入点;更新小数插入点，返回步骤1
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        // 插入头，统一问题模式
        head = new ListNode(-1, head);
        ListNode smallerCursor = head, greaterCursor;
        // 定位小数插入点
        while(smallerCursor.next != null && smallerCursor.next.val < x){
            smallerCursor = smallerCursor.next;
        }
        // 全是小数，直接返回
        if(smallerCursor.next == null) return head.next;
        // 大数插入点就在下一个
        greaterCursor = smallerCursor.next;
        // 至少存在数据
        while (greaterCursor.next != null){
            // 找到下一个小数
            while (greaterCursor.next != null && greaterCursor.next.val >= x){
                greaterCursor = greaterCursor.next;
            }
            // 找完了，返回结果
            if(greaterCursor.next == null){
                return head.next;
            }
            // 弹出下一个小数并插入到小数插入点
            addNext(smallerCursor, popNext(greaterCursor));
            // 更新小数插入点
            smallerCursor = smallerCursor.next;
        }
        // 没有更多小数，返回
        return head.next;
    }

    public ListNode popNext(ListNode node){
        ListNode next = node.next;
        node.next = node.next.next;
        return next;
    }

    public void addNext(ListNode prev, ListNode node){
        ListNode next = prev.next;
        prev.next = node;
        node.next = next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

