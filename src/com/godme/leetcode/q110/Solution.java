package com.godme.leetcode.q110;


class Solution {
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        depth(root);
        return res;
    }

    public int depth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        res &= (Math.abs(leftDepth - rightDepth))<1;
        return Math.max(leftDepth, rightDepth) + 1;
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
