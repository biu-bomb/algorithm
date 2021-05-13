package com.godme.leetcode.q687;


class Solution {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sameLeft = 0, sameRight = 0;
        if(node.left != null && node.left.val == node.val){
            sameLeft += left + 1;
        }
        if(node.right != null && node.right.val == node.val){
            sameRight += right + 1;
        }
        res = Math.max(res, sameLeft + sameRight);
        return Math.max(sameLeft, sameRight);
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

