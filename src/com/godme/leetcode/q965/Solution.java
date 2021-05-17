package com.godme.leetcode.q965;


class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root == null ? 0 : root.val);
    }

    public boolean dfs(TreeNode node, int v){
        if(node == null) return true;
        if(node.val != v) return false;
        return dfs(node.left, v) || dfs(node.right, v);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
