package com.godme.leetcode.q623;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        dfs(root, val, depth-2);
        return root;
    }

    public void dfs(TreeNode node, int val, int depth){
        if(node == null || depth < 0) return;
        if(depth == 0){
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        dfs(node.left, val, depth-1);
        dfs(node.right, val, depth-1);
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

