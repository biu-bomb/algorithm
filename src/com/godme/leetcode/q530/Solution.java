package com.godme.leetcode.q530;


class Solution {

    int res = Integer.MAX_VALUE, last = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        res = Math.min(res, Math.abs(node.val - last));
        last = node.val;
        dfs(node.right);
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
