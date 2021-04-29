package com.godme.leetcode.q21;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode fromNums(int ...arr){
        if(arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cursor = head;
        for (int i = 1; i < arr.length; i++) {
            cursor.next = new ListNode(arr[i]);
            cursor = cursor.next;
        }
        return head;
    }

    @Override
    public String toString() {
        List<Integer> collection = new ArrayList<>();
        ListNode cursor = this;
        while(cursor != null){
            collection.add(cursor.val);
            cursor = cursor.next;
        }
        return collection.toString();
    }
}