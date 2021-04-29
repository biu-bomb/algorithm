package com.godme.leetcode.q109;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // 空节点，直接返回
        if(head == null){
            return null;
        }
        // 一个节点，直接返回
        if(head.next == null){
            return new TreeNode(head.val);
        }
        // 两个节点，顺序颠倒
        if(head.next.next == null){
            return new TreeNode(head.next.val, new TreeNode(head.val), null);
        }
        // 前面添加额外一个节点，下一个节点就是中心点
        ListNode midPrev = new ListNode();
        midPrev.next = head;
        for (ListNode fast = head; fast!=null && fast.next!= null; fast = fast.next.next){
            midPrev = midPrev.next;
        }
        // 左侧节点
        ListNode left = head;
        // 中心节点
        ListNode midNode = midPrev.next;
        // 右侧节点
        ListNode right = midNode.next;
        // 断开关联
        midPrev.next = null;
        midNode.next = null;
        // 拼接二叉树
        return new TreeNode(midNode.val, sortedListToBST(left), sortedListToBST(right));
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
        ListNode node = ListNode.fromNumbers(-10,-3,0,5,9);
        Solution solution = new Solution();
        solution.sortedListToBST(node);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
