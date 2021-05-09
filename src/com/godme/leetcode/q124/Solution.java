package com.godme.leetcode.q124;


class Solution {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    public int maxGain(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));
        // 最大结果包含当前
        res = Math.max(left + right + root.val, res);
        // 当前到子节点
        return root.val + Math.max(left, right);
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
