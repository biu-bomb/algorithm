package com.godme.leetcode.q865;


class Solution {

    TreeNode node = null;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        node = root;
        dfs(root, null, 0);
        return node;
    }

    public void dfs(TreeNode current, TreeNode parent, int depth){
        if(current == null) return;
        if(depth > maxDepth){
            maxDepth = depth;
            node = parent;
        }
        dfs(current.left, current, depth+1);
        dfs(current.right, current, depth+1);
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

