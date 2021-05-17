package com.godme.leetcode.q1022;

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int res){
        if(node.left == null && node.right == null){
            return 2 * res + node.val;
        }
        res  = res * 2 + node.val;
        int left = node.left == null ? 0 : dfs(node.left, res);
        int right = node.right == null ? 0 : dfs(node.right, res);
        return left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

