package com.godme.leetcode.q1669;


class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        list1 = new ListNode(-1, list1);
        ListNode list2Tail = list2, cursor, temp;
        // 找到尾巴接入点
        while(list2Tail !=null && list2Tail.next != null) list2Tail = list2Tail.next;
        int index = 1;
        // 查找节点，接头
        for(cursor = list1; index < b; index++,cursor = cursor.next){
            if(index == a){
                temp = cursor.next;
                cursor = temp.next;
                temp.next = list2;
            }
        }
        // 如果a==b，头没接上，弥补一下
        if(a == b){
            temp = cursor.next;
            cursor = temp.next;
            temp.next = list2;
        }
        // 换尾
        list2Tail.next = cursor.next;
        return list1.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

