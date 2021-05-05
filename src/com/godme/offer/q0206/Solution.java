package com.godme.offer.q0206;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = findMid(head);
        midNode = reverseList(midNode, null);
        while (midNode != null && midNode.val == head.val){
            head = head.next;
            midNode = midNode.next;
        }
        return midNode == null;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode origin, ListNode reverse){
        if(origin == null){
            return reverse;
        }
        ListNode residue = origin.next;
        origin.next = reverse;
        return reverseList(residue, origin);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

