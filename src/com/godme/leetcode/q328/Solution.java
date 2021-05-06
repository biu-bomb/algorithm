package com.godme.leetcode.q328;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(), evenHead = new ListNode(), oddTail = combineAndConnect(head, oddHead, evenHead, true);
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    public ListNode combineAndConnect(ListNode origin, ListNode oddTail, ListNode evenTail, boolean isOdd){
        if(origin == null){
            return oddTail;
        }
        ListNode current = origin;
        origin = current.next;
        current.next = null;
        if(isOdd){
            oddTail.next = current;
            oddTail = oddTail.next;
        } else {
            evenTail.next = current;
            evenTail = evenTail.next;
        }
        return combineAndConnect(origin, oddTail, evenTail, !isOdd);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = ListNode.fromNumbers(1,2,3,4,5);
        System.err.println(solution.oddEvenList(node));
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
}
