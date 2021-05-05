package com.godme.leetcode.q1367;


class Solution {
    // 多条件、多分支的递归需要拆分，保证递归条件的隔离性
    // 如果条件和分支信息杂乱，会导致不精确的结果
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean dfs(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;
        if(head.val != root.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

