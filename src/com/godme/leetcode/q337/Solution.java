package com.godme.leetcode.q337;

class Solution {
    // 1. 选择父节点，必定不能选择任何一个子节点
    // 2. 不选择父节点
    //      2.1 可以选择全部子节点
    //      2.2 可以选择部分子节点
    //      2.3 可以忽略子节点
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    // 包含或者不包含的增益
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        // 包含
        int selected = node.val + l[1] + r[1];
        // 不包含
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
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

