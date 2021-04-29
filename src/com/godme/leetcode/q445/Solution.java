package com.godme.leetcode.q445;

import com.godme.leetcode.q21.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addAndReverse(reverse(l1), reverse(l2), null, 0);
    }
    public ListNode reverse(ListNode node){
        return reverse(node, null);
    }
    public ListNode reverse(ListNode node, ListNode result){
        if(node == null){
            return result;
        }
        ListNode next = node.next;
        node.next = result;
        return reverse(next, node);
    }
    public ListNode addAndReverse(ListNode l1, ListNode l2, ListNode result, int bingo){
        if(l1 == null && l2 == null && bingo == 0){
            return result;
        }
        ListNode current = new ListNode(bingo);
        if(l1 != null){
            current.val +=  l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            current.val += l2.val;
            l2 = l2.next;
        }
        bingo = current.val / 10;
        current.val %= 10;
        current.next = result;
        return addAndReverse(l1, l2, current, bingo);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.fromNums(7,2,4,3);
        ListNode l2 = ListNode.fromNums(5,6,4);
        System.err.println(solution.addTwoNumbers(l1, l2));
    }

}
