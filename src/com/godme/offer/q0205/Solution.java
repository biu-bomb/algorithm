package com.godme.offer.q0205;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), tail = dummy, current;
        int currentSum;
        boolean bingo = false;
        while(l1 != null || l2 != null){
            currentSum = 0;
            if(l1 != null){
                currentSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                currentSum += l2.val;
                l2 = l2.next;
            }
            currentSum += bingo ? 1 : 0;
            bingo = currentSum > 9;
            current = new ListNode(currentSum % 10);
            tail.next = current;
            tail = tail.next;
        }
        tail.next = bingo ? new ListNode(1) : null;
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

