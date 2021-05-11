package com.godme.leetcode.q563;


class Solution {

    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        sum(root);
        return res;
    }

    public int sum(TreeNode root){
        if(root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        res += Math.abs(left - right);
        return root.val + left + right;
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

