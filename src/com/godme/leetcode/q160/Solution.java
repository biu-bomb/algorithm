package com.godme.leetcode.q160;


public class Solution {
    /**
     * 无公共部分
     *      A->B->null
     *      B->A->null
     * 有公共部分
     *      a->c->b->c
     *      b->c->a->c
     * 都会有存在碰撞点，且即为所求
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode cursorA = headA, cursorB = headB;
        while(cursorA != cursorB){
           cursorA = cursorA == null ? headB : cursorA.next;
           cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
