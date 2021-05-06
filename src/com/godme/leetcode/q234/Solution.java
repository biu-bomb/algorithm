package com.godme.leetcode.q234;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        return isPalindrome(null, head, head);
    }

    public boolean isPalindrome(ListNode prevReverse, ListNode next, ListNode last){
        // 没到标准就一直收集
        if(last != null && last.next != null){
            last = last.next.next;
            ListNode current = next;
            next = current.next;
            current.next = prevReverse;
            return isPalindrome(current, next, last);
        }
        // 如果末尾不是null，为奇数节点，下移一位
        if(last != null) next = next.next;
        // 比对相等，下移
        while (next != null && prevReverse.val == next.val){
            prevReverse = prevReverse.next;
            next = next.next;
        }
        // 如果有残留，不是回文
        return prevReverse == null;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fromNumbers(1,2,3,2,1);
        Solution solution = new Solution();
        System.err.println(solution.isPalindrome(node));
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
