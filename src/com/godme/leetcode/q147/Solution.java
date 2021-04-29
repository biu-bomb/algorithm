package com.godme.leetcode.q147;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next.next == null) return head;
        head = new ListNode(-1, head);
        for (ListNode lastSorted = head.next, finder, current; lastSorted.next != null;){
            if(lastSorted.next.val < lastSorted.val){
                for(finder = head; finder.next.val < lastSorted.next.val; finder = finder.next);
                current = lastSorted.next;
                lastSorted.next = current.next;
                current.next = finder.next;
                finder.next = current;
            } else {
                lastSorted = lastSorted.next;
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {
        List<Integer> result = new ArrayList<>();
        for(ListNode cursor = this; cursor != null; cursor = cursor.next){
            result.add(cursor.val);
        }
        return result.toString();
    }

    static ListNode fromNumbers(int ...nums){
        ListNode head = new ListNode();
        ListNode cursor = head;
        for (int num: nums){
            cursor.next = new ListNode(num);
            cursor = cursor.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fromNumbers(4,2,1,3);
        Solution solution = new Solution();
        System.err.println(solution.insertionSortList(node));
    }
}
