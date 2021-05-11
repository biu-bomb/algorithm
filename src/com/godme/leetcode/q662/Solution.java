package com.godme.leetcode.q662;


import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> left = new HashMap<>();
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0 );
        return ans;
    }

    public void dfs(TreeNode node, int depth, int pos){
        if(node == null) return;
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth)+1);
        dfs(node.left, depth+1, 2*pos);
        dfs(node.right, depth+1,2*pos+1);
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

